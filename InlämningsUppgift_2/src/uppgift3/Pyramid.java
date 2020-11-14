package uppgift3;

public class Pyramid {

	public static void main(String[] args) {

		int numberOfRows = 9, coef = 1;
		int rowItems = 0;

		int counter = 0;

		for (int i = 1; i < numberOfRows; i++) {// Iteration for the rows
			for (int spacing = 1; spacing < numberOfRows - i; ++spacing) {// iteration for the escape sequences(spaces)
				System.out.print("  ");
				counter++;
			}

			while (rowItems != (2 * i - 1)) { // number of items in a row

				if (counter <= numberOfRows - 2) {
					coef = coef * 3;
					if (rowItems == 0) {
						coef = 1;
					}
					System.out.print(coef + " ");
					++counter;
				} else {

					// System. out.print((i + k - 2 * count1) + " ");
					coef = coef / (3);
					System.out.print(coef + " ");
				}

				rowItems++;
			}

			counter = rowItems = 0;

			System.out.println();

		}

	}
}


