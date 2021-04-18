package com.msa.template.coffee.payment.enums;

public class PaymentCodeDefinition {

    public enum PaymentCode implements Code{

        PAYMENT_REQUEST("결제요청"),
        PAYMENT_SUCCESS("결제성공"),
        PAYMENT_FAIL("결제실패"),
        PAYMENT_COMPLETE("결제완료")
        ;

        private String title;

        PaymentCode(String title){
            this.title = title;
        }

        @Override
        public String getCode() {
            return name();
        }

        @Override
        public String getTitle() {
            return this.title;
        }
    }

    public enum RefundCode implements Code{

        REFUND_REQUEST("환불요청"),
        REFUND_SUCCESS("환불성공"),
        REFUND_FAIL("환불실패"),
        REFUND_COMPLETE("환불완료")
        ;

        private String title;

        RefundCode(String title){
            this.title = title;
        }

        @Override
        public String getCode() {
            return name();
        }

        @Override
        public String getTitle() {
            return this.title;
        }
    }

    public enum PaymentType implements Code{
        POINT("포인트"),
        CARD("카드"),
        CASH("현금")
        ;

        private String title;

        PaymentType(String title) {
            this.title = title;
        }

        @Override
        public String getCode() {
            return name();
        }

        @Override
        public String getTitle() {
            return this.title;
        }
    }

    public enum RefundType implements Code{
        POINT("포인트"),
        CARD("카드"),
        CASH("현금")
        ;

        private String title;

        RefundType(String title) {
            this.title = title;
        }

        @Override
        public String getCode() {
            return name();
        }

        @Override
        public String getTitle() {
            return this.title;
        }
    }
}
