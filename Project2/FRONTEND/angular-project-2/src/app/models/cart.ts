export class Cart
{
    constructor(
        public id : Number,
        public amount : Number,
        public billingInfo : String,
        public discount : Number,
        public subtotal : Number,
        public total : Number
    ){}
}