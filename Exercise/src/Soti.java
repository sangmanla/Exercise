import java.util.ArrayList;
import java.util.Scanner;

public class Soti {
	static long mod = (long) 1e9 +7;
	static long fact[] = new long[200010];
	
	static void initialize(String s) {
		fact[0] = 1;
		for (int i = 1; i < fact.length; i++)
			fact[i] = (fact[i - 1] * i) % mod;
    }

    static int answerQuery(String s, int l, int r) {
    	
    	int[] alpha = new int[26];
    	for (int j = 0; j < 26; j++)
			alpha[j] = pre[r][j] - pre[l-1][j];
        
        int pCnt = 0, odd = 0;
        long dup = 1L;
        for(int c : alpha){
        	if(c!=0){
        		pCnt+=c/2;
        		if(c%2 == 1) odd++;
        		dup=(dup*fact[c/2])%mod;
        	}
        }
        
        long result = (fact[(int) pCnt] * inv(dup)) % mod;
        
        result *= (odd==0?1:odd);
        result %= mod;
        
    	return (int)result;
    }
    
    static long Inversex = 0,Inversey = 0;
	public static void InverseModulo(long a,long m){
		if(m==0){
			Inversex = 1;
			Inversey = 0;
		}
		else{
    		InverseModulo(m,a%m);
    		long temp = Inversex;
    		Inversex = Inversey;
    		Inversey = temp - (a/m)*Inversey;
    	}
    }
	
	static long inv(long a) {
		InverseModulo(a,mod);
		if(Inversex<0)
			Inversex+=mod;
		return Inversex;
	}

	static int pre[][];
			
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        initialize(s);
        int q = in.nextInt();
        
        pre = new int[s.length() + 10][26];
		for (int i = 0; i < s.length(); i++)
		{
			pre[i + 1][s.charAt(i) - 'a']++;
			for (int j = 0; j < 26; j++)
				pre[i + 1][j] += pre[i][j];
		}
		
        for(int a0 = 0; a0 < q; a0++){
            int l = in.nextInt();
            int r = in.nextInt();
            int result = answerQuery(s, l, r);
            System.out.println(result);
        }
        in.close();
    }
}
