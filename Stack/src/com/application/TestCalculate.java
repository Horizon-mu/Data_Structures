package com.application;

import com.Ordered.MyArrayStack;
import com.Ordered.MyStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Horizon~muu
 * @Date: 2020/10/05/15:48
 * @Description:
 *      计算四则运算表达式的值
 */
public class TestCalculate {
    public static void main(String[] args) {
        String expression = "4+3+(6-10+2*3)*4";
        double result = calculate(expression);
        System.out.println(result);
    }
    //定义方法计算指定表达式的值，4+3+(6-10+2*3)*4
    public static double calculate(String expression)  {
        //定义两个栈，operandStack（操作数），operatorStack（操作符）
        MyStack operandStack = new MyArrayStack();  //operandStack（操作数）
        MyStack operatorStack = new MyArrayStack();  //operatorStack（操作符）
        //遍历表达式中的操作数和操作符
        for (int i = 0; i < expression.length(); i++){
            char element = expression.charAt(i);
            //如果element是数字
            if (Character.isDigit(element)){
                //取出操作数
                StringBuilder sb = new StringBuilder();
                //只要是数字，就是操作数的一部分
                while(Character.isDigit(element)){
                    sb.append(element);//6
                    i++;                //取下个字符
                    if (i >= expression.length())//表达式结束
                        break;
                    element = expression.charAt(i); // 取下个字符
                }
                //操作数入栈
                operandStack.push(sb.toString());
                //修正i的值 
                i--;
            }else{//如果是操作符
                //1)栈为空，直接把操作符入栈
                if (operatorStack.isEmpty()){
                    operatorStack.push(element);
                    continue;
                }
                //2)操作符栈不为空
                while (!operatorStack.isEmpty()){
                    char op1 = (char) operatorStack.peek();
                    //判断栈中的运算符与当前的运算符的优先级
                    if (compareOperator(op1,element) < 0){
                        //当前运算符优先级高，直接入栈
                        operatorStack.push(element);
                        break;
                    }else if(compareOperator(op1,element) == 0){
                        //当前运算符优先级和栈中运算符优先级相同(遇到括号)
                        operatorStack.pop(); //栈中左括号出栈
                        break;
                    }else {
                        //栈顶元素优先级高
                        //取出两个操作数
                        double num1 =Double.parseDouble(operandStack.pop().toString());
                        double num2 =Double.parseDouble(operandStack.pop().toString());
                        //取栈顶运算符
                        char operator = (char) operatorStack.pop();
                        //计算num2 operator num1
                        double result = compute(operator,num2,num1);
                        //把结果存储到操作数栈中
                        operandStack.push(result);
                        //如果当前操作符栈为空，新的操作符入栈
                        if(operatorStack.isEmpty()){
                            operatorStack.push(element);
                            break;
                        }
                    }
                }
            }
        }
        //当表达式遍历完后，如果操作符栈不为空，需要继续计算
        while(!operatorStack.isEmpty()){
            char operator = (char) operatorStack.pop();
            double num1 = Double.parseDouble(operandStack.pop().toString());
            double num2 = Double.parseDouble(operandStack.pop().toString());
            double result = compute(operator,num1,num2);
            operandStack.push(result);
        }
        //当操作符栈为空，操作数栈中多与一个数，表达式错误
        if (operandStack.getSize() > 1){
            throw new RuntimeException("表达式错误");
        }
        return Double.parseDouble(operandStack.pop().toString());
    }

    //计算表达式num1 op num2的值
    private static double compute(char operator, double num1, double num2) {
        switch (operator){
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
        }
        return 0;
    }

    //判断两个运算符的优先级,如果op1优先级高返回正数，op2优先级高返回负数
    private static int compareOperator(char op1, char op2) {
        //
        if (op1 == '+' || op1 == '-'){
             if (op2 == '*' || op2 == '/' || op2 == '('){
                 //第一个运算符为+ -，第二个运算符为 *  /  (
                 return -1;
             }
        }
        if (op1 == '*' || op1 == '/'){
            if(op2 == '('){
                //第一个运算符为*/,第二个运算符为(
                return -1;
            }
        }
        if(op1 == '('){
            if(op2 == ')'){
                //第一个运算符为(,第二个运算符为)
                return 0;
            } else {
                return -1;
            }
        }
        return 1;
    }
}
