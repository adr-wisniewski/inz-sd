package sd.cmdb.domain;

public enum Quantity {
	ZERO_OR_ONE("?", "cmdb.quantity.zeroOrOne"),
        ONE("1", "cmdb.quantity.one"),
	ONE_OR_MORE("+", "cmdb.quantity.oneOrMore"),
	ZERO_OR_MORE("*", "cmdb.quantity.zeroOrMore");
	

        protected String representation;
        protected String code;

        Quantity(String representation, String code) {
            this.representation = representation;
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public String getRepresentation() {
            return representation;
        }

        @Override
        public String toString() {
            return representation;
        }
}
