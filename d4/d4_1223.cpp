#include <iostream>
using namespace std;

#define MAX 100

int T, test_case;
int n, num1, num2;
char line[MAX];
char midResult[MAX];
char cstack[MAX];
int istack[MAX];

int main(void){
    T = 10;

    for(test_case = 1; test_case <=T; test_case++){
        n = Integer.parseInt(br.readLine().trim());
        line = br.readLine().toCharArray();
        result = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            char c = line[i];
            
            if(Character.isDigit(c)) {
                result.append(c);
                continue;
            }
            
            switch(c) {
            case '(':
                s.push(c);
                break;
            case '+': case '-':
                while(!s.isEmpty()) {
                    char ch = s.peek();
                    if(ch == '(') {
                        break;
                    }
                    result.append(s.pop());
                }
                s.push(c);
                break;
            case '*': case '/':
                if(!s.isEmpty()) {
                    char ch = s.peek();
                    if(ch == '/' || ch == '*') {
                        result.append(s.pop());
                    }
                }
                s.push(c);
                break;
            case ')':
                while(!s.isEmpty()) {
                    char ch = s.peek();
                    if(ch == '(') {
                        s.pop();
                        break;
                    }
                    result.append(s.pop());
                }
                break;
            }
        }
        while(!s.isEmpty()) {
            result.append(s.pop());
        }
        
        line = result.toString().toCharArray();
        n = line.length;
        
        for (int i = 0; i < n; i++) {
            c = line[i];
            
            if(Character.isDigit(c)) {
                s2.push((int)(c - 48));
                continue;
            }
            num1 = s2.pop();
            num2 = s2.pop();
            
            switch(c) {
            case '+': s2.push(num2 + num1); break;
            case '-': s2.push(num2 - num1); break;
            case '*': s2.push(num2 * num1); break;
            case '/': s2.push(num2 / num1); break;
            }
        }
        
        System.out.println("#" + test_case + " " + s2.pop());
    }
}