import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
/**
 * Classe Filiais que contém estruturas com dados das 3 filiais
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Filiais implements Serializable, IFiliais
{
    //Não estava a conseguir copiar os arrays, perguntar ao professor, por agora fica assim até descobrir 
    //Pair[][] mesFilial;
    
    //Estes maps iniciais só podem ser preenchidos NO FIM de o ficheiro ter sido processado
    //  Mês      Pair(Nº vendas, Nº clientes)
    Map<Integer, Pair> f1;
    Map<Integer, Pair> f2;
    Map<Integer, Pair> f3;
    
    //  Produto, <NºClientes distintos, NºVendas, Total>
    Map<Produto, TripleList> produtos;     
    //  Cliente, <NºProd distintos, NºComprados, Total>
    Map<Cliente, TripleList> clientes;
    //  Cliente,    <Produto, NºCompras>
    Map<Cliente, Map<Produto, Integer>> clProds;
    
    /** 
    * Construtor vazio que cria uma instância Filial
    **/
    public Filiais()
    {
        //this.mesFilial = new Pair[3][12];
        this.f1 = new HashMap<Integer, Pair>(12);
        this.f2 = new HashMap<Integer, Pair>(12);
        this.f3 = new HashMap<Integer, Pair>(12);
        this.produtos = new HashMap<Produto, TripleList>();
        this.clientes = new HashMap<Cliente, TripleList>();
        this.clProds = new HashMap<Cliente, Map<Produto, Integer>>();
    }
    
    /** 
    * Construtor que cria um novo Filial a partir dos parâmetros dados  
    **/
    public Filiais(Map<Integer, Pair> f1, Map<Integer, Pair> f2, Map<Integer, Pair> f3, Map<Produto, TripleList> prod, Map<Cliente, TripleList> cl, Map<Cliente, Map<Produto, Integer>> clProd)
    {
        this.f1 = new HashMap<Integer, Pair>(f1);
        this.f2 = new HashMap<Integer, Pair>(f2);
        this.f3 = new HashMap<Integer, Pair>(f3);
        this.produtos = new HashMap<Produto, TripleList>(prod);
        this.clientes = new HashMap<Cliente, TripleList>(cl);
        this.clProds = new HashMap<Cliente, Map<Produto, Integer>>(clProd);
    }
    
    /** 
    * Construtor vazio que cria uma instância Filial
    **/
    public Filiais(Filiais f)
    {
        this.f1 = f.getF1();
        this.f2 = f.getF2();
        this.f3 = f.getF3();
        this.produtos = f.getProdutos();
        this.clientes = f.getClientes();
        this.clProds = f.getClProds();
    }
    
    //Getters
    /**
    * Método que devolve uma mapa com um par que contém o número total de vendas e clientes, por mês da filial em questão
    * @return Mapa com um que contém o número total de vendas e clientes
    **/
    public Map<Integer, Pair> getF1(){return new HashMap<Integer, Pair>(this.f1);}
    
    /**
    * Método que devolve uma mapa com um par que contém o número total de vendas e clientes, por mês da filial em questão
    * @return Mapa com um que contém o número total de vendas e clientes
    **/
    public Map<Integer, Pair> getF2(){return new HashMap<Integer, Pair>(this.f2);}
    
    /**
    * Método que devolve uma mapa com um par que contém o número total de vendas e clientes, por mês da filial em questão
    * @return Mapa com um que contém o número total de vendas e clientes
    **/
    public Map<Integer, Pair> getF3(){return new HashMap<Integer, Pair>(this.f3);}
    
    /**
    * Método que devolve uma mapa com um triplo que contém o número de clientes, vendas e total faturado de determinado produto, organizado por mês
    * @return Mapa com um que contém o número de clientes, vendas e total faturado de determinado produto, organizado por mês
    **/
    public Map<Produto, TripleList> getProdutos(){return new HashMap<Produto, TripleList>(this.produtos);}
    
    
    public Map<Cliente, TripleList> getClientes(){return new HashMap<Cliente, TripleList>(this.clientes);}
    public Map<Cliente, Map<Produto, Integer>> getClProds(){return new HashMap<Cliente, Map<Produto, Integer>>(this.clProds);}
    
    //Setters
    public void setF1(Map<Integer, Pair> f1)
    {
        this.f1.clear();
        this.f1 = new HashMap<Integer, Pair>(f1);
    }
    public void setF2(Map<Integer, Pair> f2)
    {
        this.f2.clear();
        this.f2 = new HashMap<Integer, Pair>(f2);
    }
    public void setF3(Map<Integer, Pair> f3)
    {
        this.f3.clear();
        this.f3 = new HashMap<Integer, Pair>(f3);
    }
    public void setProdutos(Map<Produto, TripleList> p)
    {
        this.produtos.clear();
        this.produtos = new HashMap<Produto, TripleList>(p);
    }
    public void setClientes(Map<Cliente, TripleList> c)
    {
        this.clientes.clear();
        this.clientes = new HashMap<Cliente, TripleList>(c);
    }
    public void setClProds(Map<Cliente, Map<Produto, Integer>> cp)
    {
        this.clProds.clear();
        this.clProds = new HashMap<Cliente, Map<Produto, Integer>>(cp);
    }
    
    /** 
    * Método que cria uma cópia de uma identificação de um Cliente
    **/
    public Filiais clone(){return new Filiais(this);}
    
    /** 
    * Método que testa se um objeto é igual a uma determinada identificação
    * @param      Objeto a ser testado
    * @return     True se o objeto for igual à identificação, false se o objeto passado não for igual à identificação
    **/
    public boolean equals(Object o){
       if(o == this)
            return true;
       if(o == null || o.getClass() != this.getClass() )
            return false;
       Filiais f = (Filiais) o;
       return this.f1.equals(f.getF1()) && this.f2.equals(f.getF2()) && this.f3.equals(f.getF3()) &&
              this.produtos.equals(f.getProdutos()) && 
              this.clientes.equals(f.getClientes()) &&
              this.clProds.equals(f.getClProds());
    }

    //toString e auxiliares
    private String toStringF1(){
       StringBuilder sb = new StringBuilder();
       sb.append("Filial 1: \n Mês         Nº de Vendas     Nº de Clientes").append(f1).append("\n");
       return sb.toString();
    }
    
    private String toStringF2(){
       StringBuilder sb = new StringBuilder();
       sb.append("Filial 2: \n Mês         Nº de Vendas     Nº de Clientes").append(f2).append("\n");
       return sb.toString();
    }
    
    private String toStringF3(){
       StringBuilder sb = new StringBuilder();
       sb.append("Filial 3: \n Mês         Nº de Vendas     Nº de Clientes").append(f3).append("\n");
       return sb.toString();
    }
    
    /**
     * Método que converte uma identificação numa string
     * @return  
     **/
    public String toString(){
       StringBuilder sb = new StringBuilder();
       String sf1 = toStringF1();
       String sf2 = toStringF2();
       String sf3 = toStringF3();
       sb.append("******** Dados das Filiais ********: \n").append(sf1).append(sf2).append(sf3)
         .append("******** Dados dos Produtos ********: \n");
       return sb.toString();
    
    }
     
    /**
    * Método que atualiza as caracteristicas de um dado produto na estrutura produtos
    * @param   Produto a atualizar
    * @param   Número de unidades do produto que foram compradas
    * @param   Faturação total do produto em questão
    * @param   Mês a que corresponde a atualização
    * @param   FALTA ESTE
    **/
    public void updateProduto(Produto p, int comprados, double total, int mes, int cliente)
    {
        if(!this.produtos.containsKey(p))
                this.produtos.put(p, new TripleList());
        TripleList l = this.produtos.get(p);
        if(cliente == 1) //se for 1 quer dizer que é distinto 
        { 
            int cl = l.getLeft(mes);
            l.setLeft(mes, cl+cliente);
        }
        int c = l.getMiddle(mes);
        l.setMiddle(mes, comprados+c);
        double t = l.getRight(mes);
        l.setRight(mes, total+t);
    }  
    

  
    /**
    * Método que atualiza as caracteristicas de um dado cliente na estrutura clientes
    * @param   Cliente a atualizar
    * @param   Número de unidades de produtos que foram compradas pelo cliente em questão
    * @param   Gasto total no mês em questão
    * @param   Mês a que corresponde a atualização
    * @param   FALTA ESTE
    **/
    public void updateCliente(Cliente cl, int comprados, int total, int mes, int produto)
    {
        if(!this.clientes.containsKey(cl))
                this.clientes.put(cl, new TripleList());
        TripleList l = this.produtos.get(cl);
        if(produto == 1){ //se for 1 quer dizer que é distinto 
            int pd = l.getLeft(mes);
            l.setLeft(mes, pd+produto);
        }
        int c = l.getMiddle(mes);
        l.setMiddle(mes, comprados+c);
        double t = l.getRight(mes);
        l.setRight(mes, total+t);
    }
    
    //Função que faz update de caracteristicas de um dado cliente na estrutura clProds
    public void updateClProds(Cliente cl, Produto p, int comprados){
        if(!this.clProds.containsKey(cl))
                this.clProds.put(cl, new HashMap<Produto, Integer>());
        Map<Produto, Integer> map = this.clProds.get(cl);
        if(!map.containsKey(p))
            map.put(p, comprados);
        else{
            int c = map.get(p);
            map.put(p, c+comprados);
        }
    }
    
    //Funções apenas para trabalhar com VALORES ABSOLUTOS DAS VARIAVEIS (isto é, valores já 100% calculados dos dados todos)
    
    //Função que adiciona na filial 1 um par de Vendas e Clientes
    public void addF1(double vendas, int clientes, int mes){
        Pair p = new Pair(vendas, clientes);
        this.f1.put(mes, p);
    }
    //Função que adiciona na filial 2 um par de Vendas e Clientes
    public void addF2(double vendas, int clientes, int mes){
         Pair p = new Pair(vendas, clientes);
         this.f2.put(mes, p);
    }
    //Função que adiciona na filial 3 um par de Vendas e Clientes
    public void addF3(double vendas, int clientes, int mes){
         Pair p = new Pair(vendas, clientes);
         this.f3.put(mes, p);
    }
    //Função que adiciona na estrutura produtos um registo sobre um mês
    public void addProdutos(Produto p, int clientes, int vendas, double total, int mes){
        if(!this.produtos.containsKey(p))
                this.produtos.put(p, new TripleList());
        TripleList l = this.produtos.get(p);
        l.setLeft(mes, clientes);
        l.setMiddle(mes, vendas);
        l.setRight(mes, total);
    }
    //Função que adiciona na estrutura clientes um registo sobre um mês    
    public void addClientes(Cliente c, int prods, int compr, double total, int mes){
        if(!this.clientes.containsKey(c))
                this.clientes.put(c, new TripleList());
        TripleList l = this.clientes.get(c);
        l.setLeft(mes, prods);
        l.setMiddle(mes, compr);
        l.setRight(mes, total);
    }
    //Função que adiciona na estrutura clProds um produto comprado e o respetivo numero de vezes que foi comprado
    public void addClProds(Cliente c, Produto pd, int vendas){
        if(!this.clProds.containsKey(c))
                this.clProds.put(c, new HashMap<Produto, Integer>());
        this.clProds.get(c).put(pd, vendas);
    }
    
    public void addVenda(Venda v)
    {
        updateProdutos(v.getProduto(), v.getUnidades(), v.getUnidades()*v.getPreco(), v.getMes(), /*int que representa se o cliente é distinto*/);
        updateClientes(v.getCliente(), v.getUnidades(), v.getUnidades()*v.getPreco(), v.getMes(), /*int que representa se o produto é distinto*/);
        updateClProds( v.getCliente(), v.getProduto(), v.getUnidades());  
    }
    
    public void endFiliais(/*dados finais, estatisticos (que so podem ser calculados no fim do ficheiro ter sido processado*/){};
}
