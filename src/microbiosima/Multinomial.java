/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package microbiosima;

import java.util.Random;

import utils.random.Binomial;

public class Multinomial {
//	static Random generator = new Random();
	double[] distribution;
	public int range;

	// Constructor
	Multinomial(double[] probabilities) {
		range = probabilities.length;
		distribution = new double[range];
		double cum_prob = 1;
		for (int i = 0; i < range; i++) {
			if (probabilities[i] == 0)
				distribution[i] = 0;
			else {
				distribution[i] = probabilities[i] / cum_prob;
				cum_prob = cum_prob - probabilities[i];
			}
		}
	}

	public void multisample(double[] sampled_numbers, int sample_size) {
		int N = sample_size;
		for (int i = 0; i < range - 1; i++) {
			sampled_numbers[i] = Binomial.binomial_sampling(N, distribution[i]);
			N = N - (int) sampled_numbers[i];
		}
		sampled_numbers[range - 1] = N;
	}
}
