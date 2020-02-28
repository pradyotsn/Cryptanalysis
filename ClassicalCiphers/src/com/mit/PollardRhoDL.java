package pollardrho;

import java.util.Scanner;

public class PollardRhoDL {
	public static void main(String[] args) {
		int n;
		int N;
		int alp;
		int btt;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the n:");
		n = sc.nextInt();
		System.out.println("Enter the value of N:");
		N = sc.nextInt();
		System.out.println("Enter the Value of Alpha:");
		alp = sc.nextInt();
		System.out.println("Enter Value of Beta");
		btt = sc.nextInt();
		int x0 = 1, a0 = 0, b0 = 0;
		int X0 = 0, A0 = 0, B0 = 0;
		int i = 0;
		double x = (Math.log(alp) / Math.log(btt)) % N;
		System.out.println("value of x" + x);
		double o = x % 3;

		// System.out.println("G-->" + "i" + " " + "xi" + " " + "ai" + " " + "bi" );
		// System.out.println("------------------------------");
		int xi[] = new int[n + 4];
		int ai[] = new int[n + 4];
		int bi[] = new int[n + 4];
		int x2i[] = new int[n + 4];
		int a2i[] = new int[n + 4];
		int b2i[] = new int[n + 4];

		for (i = 0; i <= n - 1;) {
			// ---------------------------------------------------------------G0
			if (x0 % 3 == 1) {
				i = i + 1;
				x0 = (btt * x0) % N;
				// System.out.println(x0);
				a0 = (a0 + 1) % (N - 1);
				// System.out.println(a0);
				b0 = b0 % (N - 1);
				// System.out.println(b0);

				// System.out.println("-->" + i + " " + x0 + " " + a0 + " " + b0);
				xi[i] = x0;
				ai[i] = a0;
				bi[i] = b0;
			}
			// ---------------------------------------------------------------G1
			if (x0 % 3 == 0) {
				i = i + 1;
				x0 = (x0 * x0) % N;
				// System.out.println(x0);
				a0 = (2 * a0) % (N - 1);
				// System.out.println(a0);
				b0 = (2 * b0) % (N - 1);
				// System.out.println(b0);

				// System.out.println("-->" + i + " " + x0 + " " + a0 + " " + b0);
				xi[i] = x0;
				ai[i] = a0;
				bi[i] = b0;
			}
			// ---------------------------------------------------------------G2
			if (x0 % 3 == 2) {
				i = i + 1;
				x0 = (alp * x0) % N;
				// System.out.println(x0);
				a0 = (a0) % (N - 1);
				// System.out.println(a0);
				b0 = (b0 + 1) % (N - 1);
				// System.out.println(b0);

				// System.out.println("-->" + i + " " + x0 + " " + a0 + " " + b0);
				xi[i] = x0;
				ai[i] = a0;
				bi[i] = b0;
			}

		}

		System.out.println("------");
		// calculation of x2i,a2i,b2i------
		// System.out.println("-----------------B2i-----------");
		int p = 0;
		for (int j = 0; j < n - 1; j++) {

			xi[0] = 1;
			j = j + 1;
			int x01 = xi[j];
			// System.out.println(x01);
			int a01 = ai[j];
			// System.out.println(a01);
			int b01 = bi[j];
			// System.out.println(b01);

			// G0------------------------------b2i
			if (x01 % 3 == 1) {
				B0 = (b01) % (N - 1);
				// System.out.println(B0);
			} else if (x01 % 3 == 0) {
				B0 = (2 * b01) % (N - 1);
				// System.out.println(B0);
			} else if (x01 % 3 == 2) {
				B0 = (b01 + 1) % (N - 1);
				// System.out.println(B0);

			}

			// System.out.println("B2i-->" + " " + B0);
			b2i[j] = B0;

		}
		// System.out.println("-----------------X2i-----------");
		// calculation of x2i,a2i,b2i------

		for (int j = 0; j < n - 1; j++) {

			xi[0] = 1;

			int x01 = xi[j];
			// System.out.println(x01);
			int a01 = ai[j];
			// System.out.println(a01);
			int b01 = bi[j];
			// System.out.println(b01);
			if (xi[j] % 3 == 1) {
				X0 = (btt * x01) % N;
				// System.out.println(X0);
			} else if (xi[j] % 3 == 0) {
				X0 = (x01 * x01) % N;
				// System.out.println(X0);
			} else if (xi[j] % 3 == 2) {
				X0 = (alp * x01) % N;
				// System.out.println(X0);

			}

			x2i[j] = X0;

			// System.out.println("X2i-->" + " " + X0);

		}
		System.out.println();
		// System.out.println("-----------------A2i-----------");

		for (int j = 0; j < n - 1; j++) {

			xi[0] = 1;
			j = j + 1;
			int x01 = xi[j];
			// System.out.println(x01);
			int a01 = ai[j];
			// System.out.println(a01);
			int b01 = bi[j];
			// System.out.println(b01);

			// G0------------------------------a2i
			if (x01 % 3 == 1) {
				A0 = (a01 + 1) % (N - 1);

				// System.out.println(A0);
			} else if (x01 % 3 == 0) {
				A0 = (2 * a01) % (N - 1);

				// System.out.println(A0);
			} else if (x01 % 3 == 2) {
				A0 = (a01) % (N - 1);

				// System.out.println(A0);

			}
			if (j % 2 != 0) {
				a2i[j] = A0;
				// System.out.println("X2i-->" + " " + A0);
			}
		}
		int l = 0;
		System.out.println("i>" + " " + "xi" + " " + "ai" + " " + "bi");
		for (int k = 1; k < n + 2; ++k) {

			System.out.println(k + "|" + xi[k] + "|" + ai[k] + "|" + bi[k] + "|");
			if (xi[k] == x2i[k * 2]) {
				l = k + 1;
				System.out.println(l + "|" + xi[l] + "|" + ai[l] + "|" + bi[l] + "|");
				break;
			}

		}
		System.out.println("-------------------------------------");
		System.out.println("i>" + " " + "x2i" + " " + "a2i" + " " + "b2i");
		for (int k = 0; k < l*2; ++k) {
			k = k + 1;
			
			if (k % 2 != 0) {
				System.out.println(k + 1 + "|" + x2i[k] + "|" + a2i[k] + "|" + b2i[k] + "|");
			}
			//if (xi[k] == x2i[k * 2]) break;
				
		}

		System.out.println("");
		System.out.println("**********" + "xi->" + "[" + l + "]>" + xi[l] + "   |" + "x2i->" + "[" + (l * 2) + "]>"
				+ x2i[l * 2 - 1]);

		int nt = (b2i[l * 2 - 1] - bi[l]) % (N-1);
		int mt = (ai[l] - a2i[l * 2 - 1]) ;
		int mx = mt / nt;
		System.out.println("******************************");
		System.out.println("log " +btt+" base "+alp+"->"+ modInverse(mx, (N-1)));
	}

	static int modInverse(int a, int m) {
		a = a % m;
		for (int x = 1; x < m; x++)
			if ((a * x) % m == 1)
				return x;
		return 1;
	}

}
