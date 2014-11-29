package businesslogic.promotionbl;

import java.rmi.Naming;
import java.util.ArrayList;

import config.RMI;
import message.ResultMessage;
import vo.CommodityVO;
import vo.PromotionVO;
import blservice.promotionblservice.PromoInputInfo;
import dataenum.PromotionType;
import dataservice.DataFactoryService;
import dataservice.PromotionDataService;

public class Promotion {
	
	private PromotionList list;
	
	private String ID;
	
	private PromotionType type;
	
	public Promotion() {
		list = new PromotionList();
	}
	
	public PromotionDataService getPromotionData(){
		try {
			DataFactoryService factory = (DataFactoryService)Naming.lookup(RMI.URL);
			PromotionDataService promotionData = factory.getPromotionData();
			return promotionData;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<PromotionVO> show(PromotionType type) {
		
		return null;
	}

	public String getID(PromotionType type) {
		this.type = type;
		this.ID = getPromotionData().getID();
		return ID;
	}

	public void addBargain(CommodityVO vo) {
		
	}

	public void addGifts(CommodityVO vo) {
		// TODO Auto-generated method stub
		
	}

	public ResultMessage submit(PromoInputInfo info) {
		// TODO Auto-generated method stub
		return null;
	}
}
