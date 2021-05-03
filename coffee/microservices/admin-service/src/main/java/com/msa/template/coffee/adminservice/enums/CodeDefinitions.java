package com.msa.template.coffee.adminservice.enums;

public class CodeDefinitions {
    public enum StatusCode{

        SALE("판매"),
        REFUND("환불"),
        ;

        private String title;

        StatusCode(String title) {
            this.title = title;
        }

        public String getCode() {
            return name();
        }

        public String getTitle() {
            return this.title;
        }
    }

    public enum PaymentType {
        POINT("포인트"),
        CARD("카드"),
        CASH("현금")
        ;

        private String title;

        PaymentType(String title) {
            this.title = title;
        }

        public String getCode() {
            return name();
        }

        public String getTitle() {
            return this.title;
        }
    }
}
