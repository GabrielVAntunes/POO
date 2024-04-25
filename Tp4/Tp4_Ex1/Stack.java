import java.util.ArrayList;

public class Stack {
    
    private ArrayList<String> stack;

    //Construtores: 
    //Construtor por omissão
    public Stack() {
        this.stack = new ArrayList<>();
    }

    //Construtor parametrizado
    public Stack(ArrayList<String> stack) {
        this.stack = new ArrayList<>(stack);
    }

    //Construtor Cópia
    public Stack(Stack s){
        this.stack = s.getStack();
    }

    //Getters e Setters:
    public ArrayList<String> getStack() {
        return this.stack;
    }

    public void setStack(ArrayList<String> stack) {
        this.stack = stack;
    }

    public String toString() {
        return "Stack{" + "stack=" + stack + '}';
    }

    public Stack clone(){
        return new Stack(this);
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Stack s = (Stack) o;
        return (this.stack == s.stack);
    }

    //Método que vai ver o elemento que está no topo da stack
    public String top(){
        return this.stack.get(this.stack.size()-1);
    }

    // Método que vai introduzir um novo elemento no topo da stack
    public void push(String s){
        this.stack.add(s);
    }

    //Método que vai retirar o elemento no topo da stack
    public void pop(){
        if(! this.empty()) this.stack.remove(this.stack.size()-1);
    }

    //Método para verificar se a stack está vazia
    public boolean empty(){
        return(this.stack.size() == 0);
    }

    //Método que retorna o tamanho da stack
    public int length(){
        return this.stack.size();
    }
}
