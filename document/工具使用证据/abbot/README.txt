1. abbot.png是软件的截图
2. pom.xml 是添加maven对界面测试的支持
具体代码是pom.xml中的以下代码
		<dependency>
			<groupId>abbot</groupId>
			<artifactId>abbot</artifactId>
			<version>1.2.0</version>
			<scope>system</scope>
			<systemPath>${project.basedir}/lib/abbot.jar</systemPath>
		</dependency>
		
		<dependency>
			<groupId>costello</groupId>
			<artifactId>costello</artifactId>
			<version>1.1.0</version>
			<scope>system</scope>
			<systemPath>${project.basedir}/lib/costello.jar</systemPath>
		</dependency>
3. SetverViewTest.xml 是使用abbot工具录制的脚本
4. ServerViewTest.java 是对界面的junit测试