package com.csc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@EnableTransactionManagement
@Qualifier("HelpTextBuilder")
public class HelpTextBuilderImpl implements HelpTextBuilder {

	public StringBuffer str = new StringBuffer();
	
	@Autowired
	public String edit() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public StringBuffer sql(String A, String B, String C, int D) {
		str.setLength(0);
		int start = 0;
		int end = D;
		int l = C.length();
		double a = (double) l / D;
		int var = (int) Math.ceil(a);
		for (int i = 1; i <= var; i++) {
			String HELPPROG = A;
			String HELPITEM = B;
			String HELPLINE = C;
			int HELPSEQ = i;
			str.append("-----Add for HELPPROG= '" + HELPPROG + "' and HELPITEM = '" + HELPITEM + "' HELPLINE = '"+ HELPLINE + "' and HELPSEQ = '" + HELPSEQ + "'------------------------\n");
			str.append("IF EXISTS (SELECT * FROM [VM1DTA].[HELPPF] WHERE HELPPROG='" + HELPPROG + "' AND HELPITEM='"+ HELPITEM + "' AND HELPSEQ='" + HELPSEQ + "')\n");
			str.append("BEGIN\n");
			str.append("\tUPDATE VM1DTA.HELPPF\n");
			str.append("\tSET HELPLINE = '" + HELPLINE + "'\n");
			str.append("\tWHERE [HELPPROG]='" + HELPPROG + "' AND HELPITEM='" + HELPITEM + "' AND HELPSEQ='" + HELPSEQ + "'\n");
			str.append("END\n");
			str.append("ELSE\n");
			str.append("BEGIN\n");
			str.append("\tINSERT INTO [VM1DTA].[HELPPF]([HELPPFX],[HELPCOY],[HELPLANG],[HELPTYPE],[HELPPROG],[HELPITEM],\n");
			str.append("\t\t[HELPSEQ],[TRANID],[VALIDFLAG],[HELPLINE],[USRPRF],[JOBNM],[DATIME])\n");
			str.append("\tVALUES\n");
			str.append("\t('HP'\n");
			str.append("\t,''\n");
			str.append("\t,'E'\n");
			str.append("\t,'" + (HELPITEM.trim().length() == 0 ? "S" : "F") + "'\n");
			str.append("\t,'" + HELPPROG + "'\n");
			str.append("\t,'" + HELPITEM + "'\n");
			str.append("\t,'" + HELPSEQ + "'\n");
			str.append("\t,''\n");
			str.append("\t,'1'\n");
			str.append("\t,'" + HELPLINE.substring(start, end) + "'\n");
			str.append("\t,'UNDERWR1'\n");
			str.append("\t,'UNDERWR1'\n");
			str.append("\t,CURRENT_TIMESTAMP);\n");
			str.append("END\n");
			str.append("GO\n");
			if (i < var - 1) {
				start = D * i ;
				end = D * (i + 1);
			}
			if (i == var - 1) {
				start = D * i + 1;
				end = l;
			}
		}
		return str;
	}

	public StringBuffer oracle(String A, String B, String C, int D) {
		str.setLength(0);
		int start = 0;
		int end = D;
		int l = C.length();
		double a = (double) l / D;
		int var = (int) Math.ceil(a);
		for (int i = 1; i < var; i++) {
			String HELPPROG = A;
			String HELPITEM = B;
			String HELPLINE = C;
			int HELPSEQ = i;
			str.append("-----Add for HELPPROG= '" + HELPPROG +"' and HELPITEM = '"+ HELPITEM +"' HELPLINE = '"+ HELPLINE +"' and HELPSEQ = '"+ HELPSEQ +"'------------------------\n");
			str.append("DECLARE\n");
			str.append("\tvarTmp NUMBER:=0;\n");
			str.append("BEGIN\n");
			str.append("\tSELECT COUNT(*) INTO varTmp FROM VM1DTA.HELPPF WHERE HELPPROG='" + HELPPROG +"' AND HELPITEM='" + HELPLINE +"' AND HELPSEQ='" + HELPSEQ +"';\n");
			str.append("\tIF (varTmp <= 0) THEN\n");
			str.append("\tINSERT INTO VM1DTA.HELPPF(HELPPFX,HELPCOY,HELPLANG,HELPTYPE,HELPPROG,HELPITEM,\n");
			str.append("\t\tHELPSEQ,TRANID,VALIDFLAG,HELPLINE,USRPRF,JOBNM,DATIME)\n");
			str.append("\tVALUES\n");
			str.append("\t('HP'\n");
			str.append("\t,''\n");
			str.append("\t,'E'\n");
			str.append("\t,'" + (HELPITEM.trim().length()==0?"S":"F")+ "'\n");
			str.append("\t,'" + HELPPROG +"'\n");
			str.append("\t,'" + HELPLINE +"'\n");
			str.append("\t,'" + HELPSEQ +"'\n");
			str.append("\t,''\n");
			str.append("\t,'1'\n");
			str.append("\t,'" + HELPLINE +"'\n");
			str.append("\t,'UNDERWR1'\n");
			str.append("\t,'UNDERWR1'\n");
			str.append("\t,CURRENT_TIMESTAMP);\n");
			str.append("ELSE\n");
			str.append("\tUPDATE VM1DTA.HELPPF\n");
			str.append("\tSET HELPLINE = '" + HELPLINE +"'\n");
			str.append("\tWHERE HELPPROG='" + HELPPROG +"' AND HELPITEM='" + HELPITEM +"' AND HELPSEQ='" + HELPSEQ +"';\n");
			str.append("\tEND IF;\n");
			str.append("END;\n");
			str.append("/\n");
			if (i < var - 1) {
				start = D * i ;
				end = D * (i + 1);
			}
			if (i == var - 1) {
				start = D * i + 1;
				end = l;
			}
		}
		return str;

	}

	
	

}
