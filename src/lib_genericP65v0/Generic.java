package lib_genericP65v0;

import java.util.ArrayList;
import java.util.List;

import com.sun.jdi.Value;

public class Generic<T,S> {
	private T attribute1, attribute2;
	private S attribute3, attribute4;
	private T[] attArray1;
	private S[] attArray2;
	private List<T> attList2 = new ArrayList();
	private List<S> attList1 = new ArrayList();
	//metodos constructores
	public Generic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Generic(T attribute1) {
		super();
		this.attribute1 = attribute1;
	}

	public Generic(T attribute1, S attribute3) {
		super();
		this.attribute1 = attribute1;
		this.attribute3 = attribute3;
	}

	public Generic(T attribute1, T attribute2, S attribute3) {
		super();
		this.attribute1 = attribute1;
		this.attribute2 = attribute2;
		this.attribute3 = attribute3;
	}

	public Generic(T attribute1, T attribute2, S attribute3, S attribute4) {
		super();
		this.attribute1 = attribute1;
		this.attribute2 = attribute2;
		this.attribute3 = attribute3;
		this.attribute4 = attribute4;
	}

	public Generic(T attribute1, S...elements) {
		this.attribute1 = attribute1;
		this.attArray2 = elements;
	}
	//Getters & Setters

	public T getAttribute1() {
		return attribute1;
	}

	public S[] getAttArray2() {
		return attArray2;
	}

	public void setAttArray2(S[] attArray2) {
		this.attArray2 = attArray2;
	}

	public void setAttribute1(T attribute1) {
		this.attribute1 = attribute1;
	}

	public T getAttribute2() {
		return attribute2;
	}

	public void setAttribute2(T attribute2) {
		this.attribute2 = attribute2;
	}

	public S getAttribute3() {
		return attribute3;
	}

	public void setAttribute3(S attribute3) {
		this.attribute3 = attribute3;
	}

	public S getAttribute4() {
		return attribute4;
	}

	public void setAttribute4(S attribute4) {
		this.attribute4 = attribute4;
	}

	public T[] getAttArray1() {
		return attArray1;
	}

	public void setAttArray1(T[] attArray1) {
		this.attArray1 = attArray1;
	}

	public List<T> getAttList2() {
		return attList2;
	}

	public void setAttList2(List<T> attList2) {
		this.attList2 = attList2;
	}

	public List<S> getAttList1() {
		return attList1;
	}

	public void setAttList1(List<S> attList1) {
		this.attList1 = attList1;
	}
	
	
	
	//Metodos genericos para implementar Datos

	/**
	 * Metodo para agregar elementos en una interfaz List de tipo S
	 * @param element Dato de tipo S
	 */


	public void addElementList(S element) {
		this.attList1.add(element);
	}
	/**
	 * Metodo para agregar elementos en una interfaz List de tipo T
	 * @param element Dato de tipo T
	 */
	public void addElementList2(T element) {
		this.attList2.add(element);
	}
	/**
	 * Metodo para agregar elementos en un arreglo de tipo T
	 * @param elements variable args de tipo T
	 */
	public void addElementArray(T...elements) {
		this.attArray1 = elements;
	}

	/**
	 * Metodo para analizar datos de tipo Double y devolver su valor de acuerdo a
	 * los siguientes tipos
	 * value=1 Numero Mayor
	 * value=2 Numero Menor
	 * value=3 Promedio
	 * value=4 Sumatoria
	 * @param values de tipo generico el primero valor corresponde al tipo
	 * y el segundo al arreglo de valores
	 * @return Resultado de tipo double
	 */

	public double typesElements(Generic<? extends Integer,? extends Double>values) {//este metodo tambien estaba solo agarradno Double first, then Integers
		double num=0;
		num = values.attArray2[0].doubleValue();//antes estaba attArray1 (solo agarra doubles)
		switch(values.getAttribute1().intValue()) {
		case 1://num mayor

			for(Double numbers: values.attArray2) {
				if(num<numbers) {
					num=numbers;
				}
			}
			break;
		case 2://num mayor

			for(Double numbers: values.attArray2) {
				if(num>numbers) {
					num=numbers;
				}
			}
			break;
		case 3://promedio
			num =0;
			for(Double numbers: values.attArray2) {
				num+=numbers;
			}
			num /= values.attArray2.length;

			break;
		case 4://suma
			num =0;
			for(Double numbers: values.attArray2) {
				num+=numbers;
			}
			break;

			default:
				return 0.0;
		}
		return num;

	}

	@Override
	public String toString() {
		return "Generic [attribute1=" + attribute1 + ", attribute2=" + attribute2 + ", attribute3=" + attribute3
				+ ", attribute4=" + attribute4 + "]";
	}





	/*hacer un metodo que optimice el codigo porque hay mucho for
	mi solucion es hacer un metodo generico que abarque el mismo recorrido
	pero tomar por parametros el tipo array y el tipo integer


	//Propuesta del inge
	 * for(double nums_: values.attArray1){
	 * switch(values.geAttribute3()){
	 * case1:
	 * if(num>nums){num=nums}break;
	 *
	 *
	 * 		}
	 * }
	*/







}
