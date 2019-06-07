import java.io.Serializable;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.List;

/**
* 
**/
public interface IGestVendasModel extends Serializable 
{
    public void carregamentoDefault();
    public GestVendasModel loadStatus(String filename) throws FileNotFoundException, IOException, ClassNotFoundException ;
    public void outroFicheiro(int op) throws IOException;
    public void saveStatus(String fileName) throws FileNotFoundException,IOException ;
    public Pair<Integer, Integer> comprasPorMes(Produto p, int mes);
    public Double faturadoPorMes(Produto p, int mes);
    //public Map<Produto, List<Double>> ftrTotal(int filial);
    public List<Produto> prodsNuncaComprados();
    public Pair<Integer,Integer> totalVendasRealizadas(int mes, int filial);
    //public List<Pair<Produto,Integer>> prodsMaisVendidos(int x);
    //public int distintosProd(Produto p);

    public List<Cliente> maioresCompradores(int filial);
    public Pair<Integer,Double> totalComprasCliente(Cliente c, int mes);
    public int totalProdutosDistintos(Cliente c, int mes);
    public List<Produto> prodsMaisVendidos(int x, int filial);
    public List<Pair<Produto,Integer>> cldistintos(List<Produto> lp, int filial);
    public List<Pair<Cliente,Integer>> clientesMaisCompraram(int x, int filial);
    public List<Pair<Produto,Integer>> prodsEcldistintos(List<Pair<Produto,Integer>> l1, List<Pair<Produto,Integer>> l2, List<Pair<Produto,Integer>> l3, int x);
    public List<Pair<Cliente, Integer>> xClientesMaisCompraram(Produto p, int x, int filial);
    public List<Pair<Cliente, Double>> xClientes_valorGasto(Produto p, int x, int filial);
    public List<Pair<Produto,Integer>> prodsMaisComprados(Cliente c, int filial);
}
