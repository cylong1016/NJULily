package businesslogic.salebl;

import java.util.ArrayList;

import po.SalesPO;
import dataenum.BillState;
import dataenum.BillType;
import dataservice.saledataservice.SaleDataService;
import vo.sale.SalesVO;
import blservice.saleblservice.SaleShowBLService;

public class SaleShow implements SaleShowBLService{
	
	private SaleTrans transPOVO;
	
	private SaleDataService saleData;
	
	public SaleShow() {
		Sale sale = new Sale();
		this.saleData = sale.getSaleData();
	}

	@Override
	public ArrayList<SalesVO> showSale() {
		return showChoose(BillType.SALE);
	}

	@Override
	public ArrayList<SalesVO> showSaleBack() {
		return showChoose(BillType.SALEBACK);
	}

	@Override
	public ArrayList<SalesVO> showSaleApproving() {
		return showChoose(BillType.SALE, BillState.APPROVALING);
	}

	@Override
	public ArrayList<SalesVO> showSaleBackApproving() {
		return showChoose(BillType.SALEBACK, BillState.APPROVALING);
	}

	@Override
	public ArrayList<SalesVO> showSalePass() {
		return showChoose(BillType.SALE, BillState.SUCCESS);
	}

	@Override
	public ArrayList<SalesVO> showSaleBackPass() {
		return showChoose(BillType.SALEBACK, BillState.SUCCESS);
	}

	@Override
	public ArrayList<SalesVO> showSaleFailure() {
		return showChoose(BillType.SALE, BillState.FAILURE);
	}

	@Override
	public ArrayList<SalesVO> showSaleBackFailure() {
		return showChoose(BillType.SALEBACK, BillState.FAILURE);
	}

	
	/**
	 * 界面显示全部的销售（销售退货）单
	 * @return 销售（销售退货）单的ArrayList
	 * @author cylong
	 * @version 2014年11月28日 下午8:36:47
	 */
	private ArrayList<SalesVO> show() {
		transPOVO = new SaleTrans();
		ArrayList<SalesVO> billsVO = new ArrayList<SalesVO>();
		ArrayList<SalesPO> billsPO = saleData.show();
		for(SalesPO po : billsPO) {
			SalesVO vo = transPOVO.poToVo(po);
			billsVO.add(vo);
		}
		return billsVO;
	}
	
	/**
	 * 根据选择的类型显示
	 * @param type
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 2:17:03 AM
	 */
	private ArrayList<SalesVO> showChoose(BillType type) {
		ArrayList<SalesVO> choose = new ArrayList<SalesVO>();
		for (SalesVO vo : show()) {
			if (vo.type == type) {
				choose.add(vo);
			}
		}
		return choose;
	}
	
	/**
	 * 根据选择的类型和状态显示
	 * @param type
	 * @param state
	 * @return
	 * @author Zing
	 * @version Dec 12, 2014 2:17:17 AM
	 */
	private ArrayList<SalesVO> showChoose(BillType type, BillState state) {
		ArrayList<SalesVO> choose = new ArrayList<SalesVO>();
		for (SalesVO vo : show()) {
			if (vo.type == type && vo.state == state) {
				choose.add(vo);
			}
		}
		return choose;
	}
}
