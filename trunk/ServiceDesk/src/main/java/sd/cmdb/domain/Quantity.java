package sd.cmdb.domain;

public enum Quantity {
	ZERO_OR_ONE {
            @Override
	    public String toString() {
	        return "?";
	    }
	},
	
	ZERO_OR_MORE {
            @Override
	    public String toString() {
	        return "*";
	    }
	},

	ONE {
            @Override
	    public String toString() {
	        return "1";
	    }
	},
	
	ONE_OR_MORE {
            @Override
	    public String toString() {
	        return "+";
	    }
	},
	
}
