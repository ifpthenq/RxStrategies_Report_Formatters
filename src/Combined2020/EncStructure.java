package Combined2020;

public class EncStructure {
	
	public String ARPNUM = "delete";	
	public String ARBIRTH = "delete";
	public String ARADMDT = "delete"	;
	public String ARPTYPE = "delete"	;
	public String ARDISDT = "delete";
	public String ARDISCOD = "delete";
	public String ARMRNUM = "delete";
	public String ARDIAG01 = "delete";	
	public String ARDIAG02 = "delete"	;
	public String ARDIAG03 = "delete"	;
	public String ARDIAG04 = "delete"	;
	public String ARDIAG05 = "delete"	;
	public String ARDIAG06 = "delete"	;
	public String ARDIAG07 = "delete"	;
	public String ARDIAG08 = "delete"	;
	public String ARDIAG09 = "delete"	;
	public String ARDIAG10 = "delete";
	public String ARDIAG11 = "delete"	;
	public String ARDIAG12 = "delete"	;
	public String ARDIAG13 = "delete";
	public String ARDIAG14 = "delete"	;
	public String ARDIAG15 = "delete"	;
	public String ARDIAG16 = "delete"	;
	public String ARDIAG17 = "delete"	;
	public String ARDIAG18 = "delete"	;
	public String ARDIAG19 = "delete"	;
	public String ARDIAG20 = "delete";
	public String ARDIAG21 = "delete"	;
	public String ARDIAG22 = "delete"	;
	public String ARDIAG23 = "delete";
	public String ARDIAG24 = "delete"	;
	public String ARADMTM = "delete"	;
	public String ARDISTM = "delete";
	public String ARLASTNM = "delete";	
	public String ARFIRSTNM = "delete";
	public String ARPATZIP = "delete"	;
	public String ERDOC1 = "delete"	;
	public String ERDOCNM1 = "delete"	;
	public String MRPHY01 = "delete"	;
	public String MRPHYNM01 = "delete";	
	public String ARCAR1CD = "delete"	;
	public String ARCAR2CD = "delete";
	public String ARCAR3CD = "delete";
	public String PHSYNPI = "delete"; 
	public String ERNPI = "delete"; 
	
	public EncStructure (String[] starray) {
		this.ARPNUM = starray[0].trim();;	
		this.ARBIRTH = starray[1].trim();;
		this.ARADMDT = starray[2].trim();	;
		this.ARPTYPE = starray[3].trim();	;
		this.ARDISDT = starray[4].trim();;
		this.ARDISCOD = starray[5].trim();;
		this.ARMRNUM = starray[6].trim();;
		this.ARDIAG01 = starray[7].trim();;	
		this.ARDIAG02 = starray[8].trim();	;
		this.ARDIAG03 = starray[9].trim();	;
		this.ARDIAG04 = starray[10].trim();	;
		this.ARDIAG05 = starray[11].trim();	;
		this.ARDIAG06 = starray[12].trim();	;
		this.ARDIAG07 = starray[13].trim();	;
		this.ARDIAG08 = starray[14].trim();	;
		this.ARDIAG09 = starray[15].trim();	;
		this.ARDIAG10 = starray[16].trim();;
		this.ARDIAG11 = starray[17].trim();	;
		this.ARDIAG12 = starray[18].trim();	;
		this.ARDIAG13 = starray[19].trim();;
		this.ARDIAG14 = starray[20].trim();	;
		this.ARDIAG15 = starray[21].trim();	;
		this.ARDIAG16 = starray[22].trim();	;
		this.ARDIAG17 = starray[23].trim();	;
		this.ARDIAG18 = starray[24].trim();	;
		this.ARDIAG19 = starray[25].trim();	;
		this.ARDIAG20 = starray[26].trim();;
		this.ARDIAG21 = starray[27].trim();	;
		this.ARDIAG22 = starray[28].trim();	;
		this.ARDIAG23 = starray[29].trim();;
		this.ARDIAG24 = starray[30].trim();	;
		this.ARADMTM = starray[31].trim();	;
		this.ARDISTM = starray[32].trim();;
		this.ARLASTNM = starray[33].trim();;	
		this.ARFIRSTNM = starray[34].trim();;
		this.ARPATZIP = starray[35].trim();	;
		this.ERDOC1 = starray[36].trim();	;
		this.ERDOCNM1 = starray[37].trim();	;
		this.MRPHY01 = starray[38].trim();	;
		this.MRPHYNM01 = starray[39].trim();;	
		this.ARCAR1CD = starray[40].trim();	;
		this.ARCAR2CD = starray[41].trim();;
		this.ARCAR3CD = starray[42].trim();;
		NPI npimap = new NPI(); 
		this.PHSYNPI = npimap.map.get(this.MRPHY01) ;
		if(this.PHSYNPI == null || this.PHSYNPI == "null") {
			this.PHSYNPI = "";
		}
		this.ERNPI = npimap.map.get(this.ERDOC1) ;
		if(this.ERNPI == null || this.ERNPI == "null") {
			this.ERNPI = "";
		}
	}

}
