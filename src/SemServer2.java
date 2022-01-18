public class SemServer2 {
    public static Double main(String[] args){
        String card_type = args[0];
        int commission = card_type.equals("visa") ? 102 : 103;
        Double balance = Double.parseDouble(args[1]);
        Double shopping_amount = Double.parseDouble(args[2]);
        boolean msg = ((commission * 1.0) / 100 * shopping_amount <= balance);
        if(msg){
            return balance-(commission * 1.0) / 100 * shopping_amount;
        }
        return -1.0;
    }
}
