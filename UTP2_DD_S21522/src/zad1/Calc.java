/**
 *
 *  @author Dajcz Dariusz S21522
 *
 */

package zad1;
import java.lang.reflect.Method;
import java.math.MathContext;
import java.util.function.BiFunction;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class Calc {
	
	
    public String doCalc(String arg) throws NullPointerException {
        String[] arguments = arg.split("\\s");
        BigDecimal score = null;
        BigDecimal arg1 = BigDecimal.valueOf(Double.parseDouble(arguments[0].replace(',', '.')));
        BigDecimal arg2 = BigDecimal.valueOf(Double.parseDouble(arguments[2].replace(',', '.')));
        Map<String, Function<BigDecimal, BigDecimal>> calc = new HashMap<>();
        MathContext mc=new MathContext(7,RoundingMode.CEILING);
        

        Function<BigDecimal, BigDecimal> funcAdd = x -> x.add(arg2) ;
        Function<BigDecimal, BigDecimal> funcMultiply = x -> x.multiply(arg2) ;
        Function<BigDecimal, BigDecimal> funcSubtract = x -> x.subtract(arg2) ;
        Function<BigDecimal, BigDecimal> funcDivide = x -> x.divide(arg2, 7, RoundingMode.CEILING) ;

        calc.put("+", funcAdd);
        calc.put("*", funcMultiply);
        calc.put("-", funcSubtract);
        calc.put("/", funcDivide);

        	return ""+ calc.get(arguments[1]).apply(arg1);
    }
}
