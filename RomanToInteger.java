import java.util.HashMap;

public class RomanToInteger {
    public static int romanToInt(String s) {

        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);

        int value = 0;
        char before = ' ';

        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='I' && before == 'V' || s.charAt(i)=='I' && before == 'X'){
                value-=1;
            }else if(s.charAt(i)=='X' && before == 'L' || s.charAt(i)=='X' && before == 'C'){
                value-=10;
            }else if(s.charAt(i)=='C' && before == 'D' || s.charAt(i)=='C' && before == 'M'){
                value-=100;
            }else{
                value += romanMap.get(s.charAt(i));
            }

            before = s.charAt(i);
        }

        return value;
    }

    public static void main(String[] args){
        String numeral1,numeral2,numeral3;
        int result1,result2,result3;



        numeral1 = "III";
        numeral2 = "LVIII";
        numeral3 = "MCMXCIV";

        result1 = romanToInt(numeral1);
        result2 = romanToInt(numeral2);
        result3 = romanToInt(numeral3);

        System.out.print("The integer value of "+numeral1+" is "+result1);
        System.out.print("The integer value of "+numeral2+" is "+result2);
        System.out.print("The integer value of "+numeral3+" is "+result3);


    }
}
