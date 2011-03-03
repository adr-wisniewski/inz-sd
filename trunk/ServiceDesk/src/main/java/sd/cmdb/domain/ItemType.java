package sd.cmdb.domain;

public enum ItemType {
	UNIVERSAL("UNI"),
	EMPLOYEE("EMP"),
        INCIDENT("INC"),
	PROBLEM("PRB"),
	RFC("RFC"),
        SERVICE("SRV");

        protected final String name;
        
        ItemType(String name) {
            this.name = name;
        }
        
        @Override
        public String toString() {
            return name;
        }
}
