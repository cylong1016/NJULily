#!/bin/sh
# Extract doc strings from javadoc files and append them to a properties file
if [ $# -lt 2 ]; then
    echo "usage: $0 <output propfile> <docfile1> [<docfile2>...]"
    exit 1
fi

cygwin=false
case "`uname`" in
  CYGWIN*) cygwin=true ;;
  *) ;;
esac

dest="$1"
echo "##############################################################" >> $dest
echo "# The following properties are auto-extracted from the javadoc" >> $dest
echo "##############################################################" >> $dest

shift
while [ $# -ne 0 ]; do
  docfile="$1"; shift
  if "$cygwin"; then
      docfile=$(cygpath -m "$docfile")
  fi
  class=$(basename "$docfile" | sed 's/.html$//g')
  actions=$(grep "<TD><CODE><B>.*#action.*(" "$docfile" | \
            sed 's/.*\(action[A-Za-z]*\)(.*/\1/g' | sort | uniq)
  for action in $actions; do
    prefix="<TD><CODE><B>.*#$action("
    value=$(sed -n \
      -e :a -e "/^$prefix.*<.TD>$/s/<TD>\(.*\)<.TD>/\1<br>/p; t" \
      -e "/^$prefix.*$/N; s/\(&nbsp;\)\(&nbsp;\)\(&nbsp;\)*/\1/; s/,   */, /; s/\n//; ta" \
    "$docfile" | tr -d '\n')
    echo "$class.$action.args=<html>$value</html>" >> "$dest"
  done
done