package businesslogic.promotionbl;

import java.util.ArrayList;

import po.CommodityItemPO;
import dataenum.ClientLevel;

public class PromotionList {
	/** 特价包 */
	private ArrayList<PromotionListItem> commodities;
	private double beforeTotal;
	/** 特价包的总价 */
	private double total;
	/** 客户等级 */
	private ClientLevel level;
	/** 购买的商品 */
	private ArrayList<PromotionListItem> gifts;
	/** 折扣 */
	private double allowance;
	/** 代金券 */
	private int voucher;
	
	public PromotionList() {
		commodities = new ArrayList<PromotionListItem>();
		gifts = new ArrayList<PromotionListItem>();
	}

	public void addBargain(PromotionListItem item) {
		commodities.add(item);
		
	}
	
	public void addGift(PromotionListItem item) {
		gifts.add(item);
	}
	
	public ArrayList<CommodityItemPO> getBargains(){
		ArrayList<CommodityItemPO> bargains = new ArrayList<>();
		for (PromotionListItem item : commodities) {
			CommodityItemPO bargain = new CommodityItemPO(item.getID(), item.getNumber(), item.getPrice());
			bargains.add(bargain);
		}
		return bargains;
	}
	
	public ArrayList<CommodityItemPO> getGifts(){
		ArrayList<CommodityItemPO> giftsRe = new ArrayList<>();
		for (PromotionListItem item : gifts) {
			CommodityItemPO gift = new CommodityItemPO(item.getID(), item.getNumber(), item.getPrice());
			giftsRe.add(gift);
		}
		return giftsRe;
	}
	
	public double getBeforeTotal() {
		for (PromotionListItem commodity : commodities) {
			beforeTotal += commodity.getTotal();
		}
		return beforeTotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public ClientLevel getLevel() {
		return level;
	}

	public void setLevel(ClientLevel level) {
		this.level = level;
	}

	public double getAllowance() {
		return allowance;
	}

	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}

	public int getVoucher() {
		return voucher;
	}

	public void setVoucher(int voucher) {
		this.voucher = voucher;
	}	
}
