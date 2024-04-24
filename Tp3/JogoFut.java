public class JogoFut {
    
    private Estado estado;
    private int golosCasa;
    private int golosVis;

    public enum Estado{
        POR_INICIAR, A_DECORRER, TERMINADO
    }

    // Construtores:
    // Construtor por omissão
    public JogoFut(){
        this.estado = Estado.POR_INICIAR;
        this.golosCasa = 0;
        this.golosVis = 0;
    }

    // Construtor Parametrizado
    public JogoFut(Estado estado, int golosCasa, int golosVis){
        this.estado = estado;
        this.golosCasa = golosCasa;
        this.golosVis = golosVis;
    }
    
    //Construtor Cópia
    public JogoFut(JogoFut jF){
        this.estado = jF.getEstado();
        this.golosCasa = jF.getGolosCasa();
        this.golosVis = jF.getGolosVis();
    }

    //Getters:
    public Estado getEstado(){
        return this.estado;
    }

    public int getGolosCasa(){
        return this.golosCasa;
    }

    public int getGolosVis(){
        return this.golosVis;
    }

    // Setters:
    public void setEstado(Estado estado){
        this.estado = estado;
    }

    public void setGolosCasa(int golosCasa){
        this.golosCasa = golosCasa;
    }

    public void setGolosVis(int golosVis){
        this.golosVis = golosVis;
    }

    // Método que dá inicio ao jogo
    public void startGame(){
        this.setEstado(Estado.A_DECORRER);
    }

    // Método que termina o jogo
    public void endGame(){
        this.setEstado(Estado.TERMINADO);
    }

    // Método que vai adicionar um golo à equipa da casa
    public void goloVisitado(){
        if (this.estado == Estado.A_DECORRER) this.golosCasa++;
    }

    // Método que vai retornar uma String com o resultado atual;
    public String resultadoAtual(){
        return this.golosCasa + " - " + this.golosVis;
    }


    //Métdo que vai adicionar um golo à equipa visitante
    public void goloVisitante(){
        if (this.estado == Estado.A_DECORRER) this.golosVis++;
    }

    public String toString(){
        switch (this.estado) {
            case POR_INICIAR:
                return "O jogo neste momento está: " + this.estado;
            
            case A_DECORRER:
                return "O jogo neste momento está: " + this.estado +
                       "A equipa da casa marcou " + this.golosCasa + " golos!" +
                       "A equipa visitante marcou " + this.golosVis + " golos!" + 
                       "neste momento está: " + this.resultadoAtual() + "!";

            default:
                return "O jogo neste momento está: " + this.estado + "\n" +
                       "A equipa da casa marcou " + this.golosCasa + " golos!\n" +
                       "A equipa visitante marcou " + this.golosVis + " golos!\n" +
                       "O jogo terminou: " + this.resultadoAtual() + "!";
        }
    }

    public JogoFut clone(){
        return new JogoFut(this);
    }

    public boolean equals(Object o){
        if( this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        JogoFut jF = (JogoFut) this;
        return(this.estado == jF.estado && this.golosCasa == jF.golosCasa && this.golosVis == jF.golosVis);
    }
}
