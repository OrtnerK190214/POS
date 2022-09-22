public class EratosthenesPrimeSieve implements PrimeSieve{

    private int grenze;

    public EratosthenesPrimeSieve(int grenze) {
        this.grenze = grenze;
    }

    @Override
    public boolean isPrime(int p) {
        return false;
    }

    @Override
    public void printPrimes() {
        for(int i=0; i<=grenze; i++){
            System.out.println(isPrime(i));
        }
    }
}
