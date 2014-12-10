package businesslogic.promotionbl;

import java.util.ArrayList;

import po.PromotionPO;
import vo.commodity.CommodityItemVO;
import vo.promotion.PromotionBargainVO;
import vo.promotion.PromotionClientVO;
import vo.promotion.PromotionCommodityVO;
import vo.promotion.PromotionTotalVO;
import businesslogic.common.ChangeCommodityItems;
import dataenum.ClientLevel;

public class PromotionTrans {
	
	private ChangeCommodityItems transPOVO;
	
	public PromotionTrans() {
		transPOVO = new ChangeCommodityItems();
	}
	
	/**
	 * 特价包PO到VO的转换
	 * @param POs
	 * @return
	 * @author Zing
	 * @version Dec 9, 2014 4:43:31 PM
	 */
	public ArrayList<PromotionBargainVO> bargainsPOtoVO(ArrayList<PromotionPO> POs) {
		ArrayList<PromotionBargainVO> VOs = new ArrayList<PromotionBargainVO>();
		for (PromotionPO po : POs) {
			String ID = po.getID();
			String beginDate = po.getBeginDate();
			String endDate = po.getEndDate();
			ArrayList<CommodityItemVO> bargains = transPOVO.itemPOToVO(po.getBargains());
			double bargainTotal = po.getBargainTotal();
			PromotionBargainVO vo = new PromotionBargainVO(ID, beginDate, endDate, bargains, bargainTotal);
			VOs.add(vo);
		}
		return VOs;
	}
	
	/**
	 * 客户等级促销包的
	 * @param POs
	 * @return
	 * @author Zing
	 * @version Dec 9, 2014 4:58:14 PM
	 */
	public ArrayList<PromotionClientVO> clientPOtoVO(ArrayList<PromotionPO> POs) {
		ArrayList<PromotionClientVO> VOs = new ArrayList<PromotionClientVO>();
		for (PromotionPO po : POs) {
			String ID = po.getID();
			String beginDate = po.getBeginDate();
			String endDate = po.getEndDate();
			ClientLevel level = po.getLevel();
			ArrayList<CommodityItemVO> gifts = transPOVO.itemPOToVO(po.getGifts());
			double allowance = po.getAllowance();
			int voucher = po.getVoucher();
			PromotionClientVO vo = new PromotionClientVO(ID, beginDate, endDate, level, gifts, allowance, voucher);
			VOs.add(vo);
		}
		return VOs;
	}

	/**
	 * 商品促销的PO转VO
	 * @param POs
	 * @return
	 * @author Zing
	 * @version Dec 9, 2014 5:20:57 PM
	 */
	public ArrayList<PromotionCommodityVO> commodityPOtoVO(ArrayList<PromotionPO> POs) {
		ArrayList<PromotionCommodityVO> VOs = new ArrayList<PromotionCommodityVO>();
		for (PromotionPO po : POs) {
			String ID = po.getID();
			String beginDate = po.getBeginDate();
			String endDate = po.getEndDate();
			ArrayList<CommodityItemVO> commodities = transPOVO.itemPOToVO(po.getCommodities());
			ArrayList<CommodityItemVO> gifts = transPOVO.itemPOToVO(po.getGifts());
			double allowance = po.getAllowance();
			int voucher = po.getVoucher();
			PromotionCommodityVO vo = new PromotionCommodityVO(ID, beginDate, endDate, commodities, gifts, allowance, voucher);
			VOs.add(vo);
		}
		return VOs;
	}
	
	/**
	 * 根据总价的促销的PO到VO
	 * @param POs
	 * @return
	 * @author Zing
	 * @version Dec 9, 2014 5:23:46 PM
	 */
	public ArrayList<PromotionTotalVO> totalPOtoVO(ArrayList<PromotionPO> POs) {
		ArrayList<PromotionTotalVO> VOs = new ArrayList<PromotionTotalVO>();
		for (PromotionPO po : POs) {
			String ID = po.getID();
			String beginDate = po.getBeginDate();
			String endDate = po.getEndDate();
			double total = po.getTotal();
			ArrayList<CommodityItemVO> gifts = transPOVO.itemPOToVO(po.getGifts());
			double allowance = po.getAllowance();
			int voucher = po.getVoucher();
			PromotionTotalVO vo = new PromotionTotalVO(ID, beginDate, endDate, total, gifts, allowance, voucher);
			VOs.add(vo);
		}
		return VOs;
	}
}
