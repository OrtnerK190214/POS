public class EratosthenesPrimeSieve implements PrimeSieve {

    private int grenze;
    private boolean[] gestrichen = new boolean[grenze];

    public EratosthenesPrimeSieve(int grenze) {
        this.grenze = grenze;
        for (int i = 2; i<grenze; i++) {
            gestrichen[i] = false;
        }
    }

    @Override
    public boolean isPrime(int p) {
        for (int i = 2; i<=grenze; i++)
        {
            if (gestrichen[i] = true)
            {
                return true;
            }
            for (int j = i*i; j<=grenze; i += p)
            {
                gestrichen[j] = true;
            }
        }
        return false;
    }

    @Override
    public void printPrimes() {
        for (int i = 2; i <= grenze; i++) {
            if (isPrime(i) == true) {
                System.out.println(isPrime(i));
            }
        }
    }
}
