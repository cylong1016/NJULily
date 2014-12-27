package businesslogic.salebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.SalesPO;
import vo.sale.SalesVO;
import dataenum.BillState;
import dataenum.BillType;
import dataservice.saledataservice.SaleDataService;

public class SaleShow {

	private SaleDataService saleData;

	public SaleShow() {
		Sale sale = new Sale();
		this.saleData = sale.getSaleData();
	}

	public ArrayList<SalesVO> showSale() throws RemoteException {
		return showChoose(BillType.SALE);
	}

	public ArrayList<SalesVO> showSaleBack() throws RemoteException {
		return showChoose(BillType.SALEBACK);
	}

	public ArrayList<SalesVO> showSaleApproving() throws RemoteException {
		return showChoose(BillType.SALE, BillState.APPROVALING);
	}

	public ArrayList<SalesVO> showSaleBackApproving() throws RemoteException {
		return showChoose(BillType.SALEBACK, BillState.APPROVALING);
	}

	public ArrayList<SalesVO> showSalePass() throws RemoteException {
		return showChoose(BillType.SALE, BillState.SUCCESS);
	}

	public ArrayList<SalesVO> showSaleBackPass() throws RemoteException {
		return showChoose(BillType.SALEBACK, BillState.SUCCESS);
	}

	public ArrayList<SalesVO> showSaleFailure() throws RemoteException {
		return showChoose(BillType.SALE, BillState.FAILURE);
	}

	public ArrayList<SalesVO> showSaleBackFailure() throws RemoteException {
		return showChoose(BillType.SALEBACK, BillState.FAILURE);
	}

	/**
	 * 界面显示全部的销售（销售退货）单
	 * @return 销售（销售退货）单的ArrayList
	 * @author cylong
	 * @version 2014年11月28日 下午8:36:47
	 * @throws RemoteException
	 */
	private ArrayList<SalesVO> show() throws RemoteException {
		ArrayList<SalesVO> billsVO = new ArrayList<SalesVO>();
		ArrayList<SalesPO> billsPO = saleData.show();
		for(SalesPO po : billsPO) {
			SalesVO vo = SaleTrans.poToVo(po);
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
	 * @throws RemoteException
	 */
	private ArrayList<SalesVO> showChoose(BillType type) throws RemoteException {
		ArrayList<SalesVO> choose = new ArrayList<SalesVO>();
		ArrayList<SalesVO> show = show();
		for(SalesVO vo : show) {
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
	 * @throws RemoteException
	 */
	private ArrayList<SalesVO> showChoose(BillType type, BillState state) throws RemoteException {
		ArrayList<SalesVO> choose = new ArrayList<SalesVO>();
		ArrayList<SalesVO> show = show();
		for(SalesVO vo : show) {
			if (vo.type == type && vo.state == state) {
				choose.add(vo);
			}
		}
		return choose;
	}

	public ArrayList<SalesVO> showSaleDraft() throws RemoteException {
		return showChoose(BillType.SALE, BillState.DRAFT);
	}

	public ArrayList<SalesVO> showSaleBackDraft() throws RemoteException {
		return showChoose(BillType.SALEBACK, BillState.DRAFT);
	}
}
