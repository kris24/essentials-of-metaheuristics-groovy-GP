package treeGP

class Operator {
    
    def arityTwo = ['+', '-', '/', '*']
    def arityOne = ['sin', 'cos', 'tan']
    def symbol
    
    def operator(symbol) {
        assert arityTwo.contains(symbol) || arityOne.contains(symbol)
        this.symbol = symbol
        
    }
    
    def evaluate(arg1, arg2) {
        switch (symbol) {
            case '+':
                return arg1 + arg2
            case '-':
                return arg1 - arg2
            case '*':
                return arg1 * arg2
            case '/':
                return arg1 / arg2
            
        }
    }
    
}