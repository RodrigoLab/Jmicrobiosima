/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package microbiosima;

/**
 *
 * @author John
 */
public class Individual {

	private double[] microbiome;//NOTE: is that possible to use int[]
	
	private int numberEnvironmentalSpecies;
	private int numberMicrobePerHost;
	
	public Individual(String[] initial_microbiome, int nomph, int noes) {
		numberEnvironmentalSpecies = noes;
		microbiome = new double[numberEnvironmentalSpecies];
		for (int i = 0; i < numberEnvironmentalSpecies; i++) {
			microbiome[i] = Double.parseDouble(initial_microbiome[i]);
		}
		numberMicrobePerHost = nomph;
	}

	public String microbial_sequences() {
		char[] microbiome_sequence = new char[numberEnvironmentalSpecies];
		for (int i = 0; i < numberEnvironmentalSpecies; i++) {
			if (microbiome[i] > 0) {
				microbiome_sequence[i] = '1';
			} else {
				microbiome_sequence[i] = '0';
			}
		}
		return new String(microbiome_sequence);
	}

	/**
	 * @return the microbiome
	 */
	public double[] getMicrobiome() {
		return microbiome;
	}
//	public double getMicrobiome(int i) {
//		return microbiome[i];
//	}
}
