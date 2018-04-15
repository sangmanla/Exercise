import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;


public class Soti2 {
	@SuppressWarnings("rawtypes")
	static InputReader in;
	static PrintWriter out;

	static long mod = (long) 1e9 + 7;

	static long pow(long a)
	{
		long ans = 1;
		long b = mod - 2;
		while (b > 0)
		{
			if ((a & 1) == 1)
				ans = (ans * a) % mod;
			a = (a * a) % mod;
			b >>= 1;
		}
		return ans;
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

	static void solve()
	{
		String a = in.nextLine();
		int pre[][] = new int[a.length() + 10][26];
		for (int i = 0; i < a.length(); i++)
		{
			pre[i + 1][a.charAt(i) - 'a']++;
			for (int j = 0; j < 26; j++)
				pre[i + 1][j] += pre[i][j];
		}
		int q = in.ni();
		long fact[] = new long[200010];
		fact[0] = 1;
		for (int i = 1; i < fact.length; i++)
			fact[i] = (fact[i - 1] * i) % mod;
		while (q-- > 0)
		{
			int l = in.ni() - 1, r = in.ni() - 1;
			int get[] = new int[26];
			for (int j = 0; j < 26; j++)
				get[j] = pre[r + 1][j] - pre[l][j];
			int odd = 0;
			long ans = 0, pr = 1;
			for (int i = 0; i < 26; i++)
			{
				if (get[i] % 2 == 1)
					odd++;
				ans += get[i] / 2;
				pr = (pr * fact[get[i] / 2]) % mod;
				System.out.println("pr : " + pr);
			}
			//debug(inv(pr) + " " + pr + " " + ans);
			ans = (inv(pr) * fact[(int) ans]) % mod;
			if (odd > 0)
				ans *= odd;
			ans %= mod;
			out.println(ans);
		}
	}

	@SuppressWarnings("rawtypes")
	static void soln()
	{
		in = new InputReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.flush();
	}

	static void debug(Object... o)
	{
		System.out.println(Arrays.deepToString(o));
	}

	public static void main(String[] args)
	{
		new Thread(null, new Runnable()
		{
			public void run()
			{
				try
				{
					soln();
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}, "1", 1 << 26).start();
	}

	// To Get Input
	// Some Buffer Methods
	static class InputReader<SpaceCharFilter>
	{

		private final InputStream stream;
		private final byte[] buf = new byte[8192];
		private int curChar, snumChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream)
		{
			this.stream = stream;
		}

		public int snext()
		{
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars)
			{
				curChar = 0;
				try
				{
					snumChars = stream.read(buf);
				} catch (IOException e)
				{
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int ni()
		{
			int c = snext();
			while (isSpaceChar(c))
			{
				c = snext();
			}
			int sgn = 1;
			if (c == '-')
			{
				sgn = -1;
				c = snext();
			}
			int res = 0;
			do
			{
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public long nl()
		{
			int c = snext();
			while (isSpaceChar(c))
			{
				c = snext();
			}
			int sgn = 1;
			if (c == '-')
			{
				sgn = -1;
				c = snext();
			}
			long res = 0;
			do
			{
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public int[] nextIntArray(int n)
		{
			int a[] = new int[n];
			for (int i = 0; i < n; i++)
			{
				a[i] = ni();
			}
			return a;
		}

		public long[] nextLongArray(int n)
		{
			long a[] = new long[n];
			for (int i = 0; i < n; i++)
			{
				a[i] = nl();
			}
			return a;
		}

		public String readString()
		{
			int c = snext();
			while (isSpaceChar(c))
			{
				c = snext();
			}
			StringBuilder res = new StringBuilder();
			do
			{
				res.appendCodePoint(c);
				c = snext();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public String nextLine()
		{
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			StringBuilder res = new StringBuilder();
			do
			{
				res.appendCodePoint(c);
				c = snext();
			} while (!isEndOfLine(c));
			return res.toString();
		}

		public boolean isSpaceChar(int c)
		{
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private boolean isEndOfLine(int c)
		{
			return c == '\n' || c == '\r' || c == -1;
		}

		public interface SpaceCharFilter
		{
			public boolean isSpaceChar(int ch);
		}

	}
}
