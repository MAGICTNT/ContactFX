package fr.mj.metier;

import java.util.Random;

/**
 * 
 * @author Cour Afpa
 *
 * @param <T> permet de cr�er un tableau modulable
 */

public class Tableau<T extends Comparable<T>>  {
	Random alea = new Random();
	private Object[] values;
	private int size;

	public Tableau() {
		values = new Object[5];
		size = 0;
	}

	/**
	 * 
	 * @return permet de r�cup�rer la taille d'un tableau
	 */
	
	public int size() {
		return size;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int indice) {
		indiceHorsLimite(indice);
		return (T) values[indice];
	}

	/**
	 * 
	 * @param permet d'ajouter un �l�ment
	 */
	
	public void add(T instance) {
		redimensionner(size + 1);
		values[size++] = instance;
	}

	/**
	 * 
	 * @param permet redimensionner un tableau
	 */
	
	private void redimensionner(int newLength) {
		if (newLength > values.length) {
			newLength = (int) Math.min(newLength + 5d, newLength * 1.05);
			Object[] temp =  new Object[size + newLength];
			for (int i = 0; i < size; i++)
				temp[i] = values[i];
			values =  temp;
		}
	}

	/**
	 * 
	 * @param permet d'ajouter une donn�e � une place pr�cise 
	 */
	
	public void add(int indice, T instance) {
		indiceHorsLimite(indice);
		redimensionner(size + 1);
		for (int i = size; i > indice; i--)
			values[i] = values[i - 1];
		values[indice] = instance;
		size++;
	}

	/**
	 * 
	 * @param permet d'ajouter les donn�es d'un tableau � ce tableau
	 */
	
	public void addAll(T[] tableau) {
		redimensionner(size + tableau.length);
		for (int i = 0; i < tableau.length; i++)
			values[size++] = tableau[i];
	}

	/**
	 * 
	 * @param permet de v�rifier si une donn�e existe dans notre tableau
	 * @return return un boolean
	 */
	
	public boolean contains(T instance) {
		return indexOf(instance) != -1;
	}
	
	/**
	 * 
	 * @param permet de v�rifier la position d'une donner pr�cis dans le tableau
	 */

	public int indexOf(T instance) {
		int index = -1;
		int i = 0;
		while (index == -1 && i < size)
			if (values[i++].equals(instance))
				index = i - 1;
		return index;
	}

	
	/**
	 * 
	 * @param permet de supprimer une information selon sa position dans le tableau
	 */
	
	public void removeAt(int indice) {
		indiceHorsLimite(indice);
		for (int i = indice; i < size; i++)
			values[i] = values[i + 1];
		size--;
	}

	/**
	 * 
	 * @param permet de retirer une donn�e � un tableau choisi
	 */
	
	public void remove(T instance) {
		if (contains(instance))
			removeAt(indexOf(instance));
	}

	/**
	 * @param permet de ranger un tableau
	 */
	
	public void sort() {
		quickSort(0, size - 1);
	}
	
	/**
	 * @param permet de m�langer les donner d'un tableau
	 */
	
	public void shuffle() {
		for (int i = 0; i < size / 2; i++) {
			echangerElements(alea.nextInt(size), alea.nextInt(size));
		}
	}

	private void quickSort(int limiteGauche, int limitedroite) {
		if (limiteGauche < limitedroite) {
			int indicePivot = partition(limiteGauche, limitedroite);
			quickSort(limiteGauche, indicePivot - 1);
			quickSort(indicePivot + 1, limitedroite);
		}
	}

	@SuppressWarnings("unchecked")
	private int partition(int limiteGauche, int limitedroite) {
		T valeurPivot = (T) values[limiteGauche];
		int d = limiteGauche + 1;
		int f = limitedroite;
		while (d < f) {
			if (((Comparable<T>) values[f]).compareTo(valeurPivot) >= 0)
				f--;
			if (d < f && ((Comparable<T>) values[d]).compareTo(valeurPivot) <= 0)
				d++;
			echangerElements(d, f);
		}
		if ( ((Comparable<T>) values[d]).compareTo(valeurPivot) > 0)
			d--;
		values[limiteGauche] = values[d];
		values[d] = valeurPivot;
		return d;
	}
	private void echangerElements(int i, int j) {
		Object temp = values[i];
		values[i] = values[j];
		values[j] = temp;
	}

	private void indiceHorsLimite(int indice) {
		if (indice >= size || indice < 0)
			throw new TableauException(
					String.format("Indice %d hors limite ...", indice));
	}

}
