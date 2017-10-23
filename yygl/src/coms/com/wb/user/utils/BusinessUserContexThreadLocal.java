package com.wb.user.utils;

import com.wb.user.model.UaasUserVO;

public class BusinessUserContexThreadLocal extends ThreadLocal<UaasUserVO>{

	@Override
	protected UaasUserVO initialValue() {
		// TODO Auto-generated method stub
		return super.initialValue();
	}
}
