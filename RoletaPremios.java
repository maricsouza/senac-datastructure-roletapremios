import java.util.Random;

public class RoletaPremios {
    private Premio inicio;
    private Premio fim;

    public RoletaPremios() {
    }


    public Premio getInicio() {
        return inicio;
    }

    public Premio getFim() {
        return fim;
    }

    public void setInicio(Premio inicio) {
        this.inicio = inicio;
    }

    public void setFim(Premio fim) {
        this.fim = fim;
    }

    public void adicionar (String premio) {

        if(inicio == null) {
            inicio = new Premio(premio);
            inicio.setAnterior(inicio);
            inicio.setProximo(inicio);
            fim = inicio;  
        } else {
            Premio newPremio = new Premio(premio);
            
            fim.setProximo(newPremio);
            newPremio.setAnterior(fim);
            newPremio.setProximo(inicio);
            inicio.setAnterior(newPremio);

            fim = newPremio;
        }

    }


    public void verPremios () {
        Premio premios = inicio;

        if(inicio == null) return;

        do {
            System.out.println(premios.getNome());
            premios = premios.getProximo();
        }
        while(premios != inicio);

    }

    public void remover (String premio) {
        Premio p = inicio;

        if(inicio == null) return;
        
        do {
            if(p.getNome().equalsIgnoreCase(premio)) {        
                p.getAnterior().setProximo(p.getProximo());
                p.getProximo().setAnterior(p.getAnterior());

                if(p == inicio && p == fim) inicio = fim = null;
                else if(p == inicio) inicio = p.getProximo();
                else if(p == fim) fim = p.getAnterior();

                break;
            }
            p = p.getProximo();
        } while(p != inicio);
            

        

    }
    
    public void alterar (String lastValue, String newValue) {
        Premio p = inicio;

        if(inicio == null) return;

        do {
            p = p.getProximo();

        } while(!p.getNome().equalsIgnoreCase(lastValue));

        p.setNome(newValue);
    }

    public int totalPremios () {
        Premio valor = inicio;
        int qtd = 0;

        if(inicio == null) return qtd;

        qtd++;

        while(valor.getProximo() != inicio) {
           valor = valor.getProximo();
           qtd++;
        }

        return qtd;
    }

    public String rodar () {

        if(inicio == null) return "Não há prêmios";

        Random random = new Random();
        Premio valorRoleta = inicio;

        int voltas = random.nextInt(100);

        for(int i = 0; i < voltas; i++) {
            valorRoleta = valorRoleta.getProximo();
        }

        return valorRoleta.getNome();
    }
}
