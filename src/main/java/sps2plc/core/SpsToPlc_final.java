package sps2plc.core;

import java.util.*;

import java.util.regex.*;

import java.io.*;



public class SpsToPlc_final {

	public static String positiveInt = "^[0-9]*[1-9][0-9]*$";

	public static String nonnegativeInt = "^\\d+$";

	public static int specSize;

	public static int mIndex = 50;

	public static int tonIndex = 37;

	public static String mNum = "";

	public static String s = "";

	

	public static void main(String []args) throws IOException {
		System.out.println(
			specAnlysis(
				new ArrayList<String>(){{
					add("When X, o is true.");
					add("When X, o is false.");
					add("When X, p is true.");
					add("When X, p is false.");
				}},
				"1<2\r\n3=4"
			).substring(6)
		);

		System.out.println(
				specAnlysis(
						new ArrayList<String>(){{
							add("When X, o is true.");
							add("When X, o is false.");
							add("When X, p is true.");
							add("When X, p is false.");
						}},
						""
				).substring(10)
		);
	}

	public static void reset() {
		positiveInt = "^[0-9]*[1-9][0-9]*$";
		nonnegativeInt = "^\\d+$";
		mIndex = 50;
		tonIndex = 37;
		mNum = "";
		s = "";
	}


	public static String specAnlysis(List<String> sp, String priority) {
//		for (String str: sp) {
//			System.out.println(str);
//		}
//		System.out.println();
//		System.out.println(priority);

		//size为规约条数，spec[][]为整理后的规约

		int size = sp.size();

		specSize = size;

		String[][] spec = new String[size][10];



		//对每条规约进行整理

		for(int i=0; i<sp.size(); i++) {

			String spstr = (String)sp.get(i);

			String errorFlag = "";

			for(int j=0; j<10; j++)

				spec[i][j] = "";



			//对每条规约整理，改变符号，删除空格

			int indexBlank = spstr.indexOf(' ');

			while(indexBlank == 0) {									//删除开头的空格

				spstr = spstr.replaceFirst(" ", "");

				indexBlank = spstr.indexOf(' ');

			}

			spstr = spstr.replaceAll(" ","");

			spstr = spstr.replaceAll("and","/\\\\");

			spstr = spstr.replaceAll("or", "\\\\/");

			spstr = spstr.replaceAll("not", "!");



			//记录相关关键字的下标，以获取事件或状态对应的字符串

			int indexComma = spstr.indexOf(',');

			int indexUntil = spstr.indexOf("until");





			do {

				if(!spstr.contains(",")) {

					errorFlag = "COMMA";

					break;

				}



				//确定延时

				if(spstr.contains("delayL") && spstr.contains("delayRE")) {



					//获得延时量

					int indexDelayL = spstr.indexOf("delayL");

					String strDelay = spstr.substring(indexDelayL);

					int indexCommaDelayL = strDelay.indexOf(',');

					spec[i][3] = strDelay.substring(7, indexCommaDelayL);

					int indexDelayRE = strDelay.indexOf("delayRE");

					strDelay = strDelay.substring(indexDelayRE);

					int indexCommaDelayRE = strDelay.indexOf(',');

					spec[i][5] = strDelay.substring(8, indexCommaDelayRE);



					//检查延时量是否符合要求

					int delayL = -1;

					int delayRE = -1;

					Pattern pattern = Pattern.compile(nonnegativeInt);

					Matcher isNum = pattern.matcher(spec[i][3]);

					if(isNum.find())

						delayL = Integer.valueOf(spec[i][3]).intValue();

					pattern = Pattern.compile(nonnegativeInt);

					isNum = pattern.matcher(spec[i][5]);

					if(isNum.find())

						delayRE = Integer.valueOf(spec[i][5]).intValue();



					//确定延时类型

					if(delayL == 0 && delayRE != 0)

						spec[i][8] = "5";

					if(delayL != 0 && delayRE != 0)

						spec[i][8] = "6";

					if(delayL != 0 && delayRE == 0)

						spec[i][8] = "7";

					if(delayL == 0 && delayRE == 0)

						spec[i][8] = "0";



					if(delayL == -1 || delayRE == -1) {

						errorFlag = "DELAY";

						break;

					}

				}

				else if(spstr.contains("delayL") && spstr.contains("delayR")){



					//获得延时量

					int indexDelayL = spstr.indexOf("delayL");

					String strDelay = spstr.substring(indexDelayL);

					int indexCommaDelayL = strDelay.indexOf(',');

					spec[i][3] = strDelay.substring(7, indexCommaDelayL);

					int indexDelayR = strDelay.indexOf("delayR");

					strDelay = strDelay.substring(indexDelayR);

					int indexCommaDelayR = strDelay.indexOf(',');

					spec[i][4] = strDelay.substring(7, indexCommaDelayR);

	//				System.out.println(spec[i][3]+"   ***   "+spec[i][4]);



					//检查延时量是否符合要求

					int delayL = -1;

					int delayR = -1;

					Pattern pattern = Pattern.compile(nonnegativeInt);

					Matcher isNum = pattern.matcher(spec[i][3]);

					if(isNum.find())

						delayL = Integer.valueOf(spec[i][3]).intValue();

					pattern = Pattern.compile(positiveInt);

					isNum = pattern.matcher(spec[i][4]);

					if(isNum.find())

						delayR = Integer.valueOf(spec[i][4]).intValue();



					//确定延时类型

					if(delayL == 0 && delayR != 0)

						spec[i][8] = "2";

					if(delayL != 0 && delayR != 0)

						spec[i][8] = "3";



					if(delayL == -1 || delayR == -1 || delayR <= delayL) {

						errorFlag = "DELAY";

						break;

					}

				}

				else if(spstr.contains("delayL")){



					//获得延时量

					int indexDelayL = spstr.indexOf("delayL");

					String strDelay = spstr.substring(indexDelayL);

					int indexCommaDelayL = strDelay.indexOf(',');

					spec[i][3] = strDelay.substring(7, indexCommaDelayL);



					//检查延时量是否符合要求

					int delayL = -1;

					Pattern pattern = Pattern.compile(nonnegativeInt);

					Matcher isNum = pattern.matcher(spec[i][3]);

					if(isNum.find())

						delayL = Integer.valueOf(spec[i][3]).intValue();



					//确定延时类型

					if(spstr.contains("exists"))

						spec[i][8] = "1";

					else

						spec[i][8] = "4";



					if(delayL == -1) {

						errorFlag = "DELAY";

						break;

					}

				}

				else if(spstr.contains("delayRE") || spstr.contains("delayR")) {

					errorFlag = "DELAY";

					break;

				}

				else

					spec[i][8] = "0";



				//确定范围

				if(spstr.contains("Global"))

					spec[i][0] = "1";

				else if(spstr.contains("After") && spstr.contains("until")) {

					spec[i][0] = "3";

					spec[i][1] = spstr.substring(indexBlank, indexUntil);

					spec[i][2] = spstr.substring(indexUntil+5, indexComma);

				}

				else if(spstr.contains("After")) {

					spec[i][0] = "2";

					spec[i][1] = spstr.substring(indexBlank, indexComma);

				}

				else if(spstr.contains("When")) {

					spec[i][0] = "4";

					spec[i][1] = spstr.substring(indexBlank, indexComma);

				}

				else {

					errorFlag = "SCOPE";

					break;

				}



				//排除逗号错误导致延时量中包含非数字字符delay的情况

				if(spec[i][1].contains("delay") || spec[i][2].contains("delay")){

					errorFlag = "COMMA";

					break;

				}



				//排除范围和延时不匹配的情况

				if((spec[i][0].equals("1") || spec[i][0].equals("2"))&& (spec[i][8].equals("5") || spec[i][8].equals("6") || spec[i][8].equals("7"))) {

					errorFlag = "DELAY";

					break;

				}



				//确定属性

				if(spstr.contains("true"))

					spec[i][6] = "1";

				else if(spstr.contains("false"))

					spec[i][6] = "2";

				else if(spstr.contains("exists"))

					spec[i][6] = "3";

				else {

					errorFlag = "PROPERTY";

					break;

				}



				//确定控制对象

				int indexProperty = -1;

				int indexLastComma = -1;

				if(spec[i][6].equals("3"))

					indexProperty = spstr.indexOf("exists");

				else if(spec[i][6].equals("1"))

					indexProperty = spstr.indexOf("istrue");

				else if(spec[i][6].equals("2"))

					indexProperty = spstr.indexOf("isfalse");

				indexLastComma = spstr.lastIndexOf(",");

				if(indexProperty == -1 || indexLastComma == -1 || indexProperty < indexLastComma) {

					errorFlag = "PROPERTY";

					break;

				}

				else

					spec[i][7] = spstr.substring(indexLastComma+1, indexProperty);





	//			System.out.println(spec[i][0]+ "\t" + spec[i][1]+ "\t" + spec[i][2]);

			}while(false);

		}

/*			for (int i = 0; i < specSize; ++i) {
			for (int j = 0; j < 10; ++j) {
				System.out.printf("%s\t", spec[i][j]);
			}
			System.out.println();
		}

		System.exit(0);*/


		return codeGeneration(spec, priority);

	}


	//通过规约生成代码

	public static String codeGeneration(String[][] spec, String priority) {

//		for (int i = 0; i < spec.length; i++) {
//			for (int j = 0; j < spec[i].length; j++) {
//				System.out.print(spec[i][j] + ' ');
//			}
//			System.out.println();
//		}

		int size = specSize;

		int[] sameAs = new int[size];

		int[] isSameFirst = new int[size];

		String[] mOut = new String[size];

		String[] ilModule = new String[size];

		

		//初始化

		//数组sameAs用于记录该条规约和哪条控制对象相同

		//isSameFirst用于记录该条规约有无相同控制对象，是否为第一次出现

		//mOut用于记录该条规约用于输出的中间继电器编号

		//ilModule用于记录该条规约对应的不包括属性部分的IL代码

		for(int i=0; i<size; i++) {

			sameAs[i] = i;

			isSameFirst[i] = 0;

			mOut[i] = "";

			ilModule[i] = "";

		}

		

		for(int i=0; i<size; i++) {

			for(int j=i+1; j<size; j++) {

				if(spec[i][7].equals(spec[j][7])) {

					sameAs[j] = sameAs[i];

					isSameFirst[sameAs[i]]++;

				}

			}

		}

		





		

		for(int i=0; i<size; i++) {

			

//			System.out.println("same as: "+sameAs[i]+"\tis same first: "+isSameFirst[i]);

			

			//获得模式类型

			int scopeType = Integer.valueOf(spec[i][0]).intValue();

			int propertyType = Integer.valueOf(spec[i][6]).intValue();

			int delayType = Integer.valueOf(spec[i][8]).intValue();

			int specType = propertyType * 100 + scopeType * 10 + delayType;

			int specNoFalse = specType;

			if(propertyType == 2)

				specNoFalse = specNoFalse - 100;

//			System.out.println("specType: "+specType);

			spec[i][1] = spec[i][1].replaceAll("/\\\\", "/");

			spec[i][1] = spec[i][1].replaceAll("\\\\/", "\\\\");

			spec[i][2] = spec[i][2].replaceAll("/\\\\", "/");

			spec[i][2] = spec[i][2].replaceAll("\\\\/", "\\\\");

			

			//根据模式生成程序模块

			switch(specNoFalse)

			{

				case 110:

					ilModule[i] = module110(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 120:

					ilModule[i] = module120(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 130:

					ilModule[i] = module130(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 140:

					ilModule[i] = module140(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 112:

					ilModule[i] = module112(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 113:

					ilModule[i] = module113(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 114:

					ilModule[i] = module114(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 122:

					ilModule[i] = module122(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 123:

					ilModule[i] = module123(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 124:

					ilModule[i] = module124(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 132:

					ilModule[i] = module132(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 133:

					ilModule[i] = module133(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 134:

					ilModule[i] = module134(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 135:

					ilModule[i] = module135(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 136:

					ilModule[i] = module136(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 137:

					ilModule[i] = module137(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 142:

					ilModule[i] = module142(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 143:

					ilModule[i] = module143(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 144:

					ilModule[i] = module144(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 145:

					ilModule[i] = module145(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 146:

					ilModule[i] = module146(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 147:

					ilModule[i] = module147(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 310:

					ilModule[i] = module310(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 320:

					ilModule[i] = module320(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 330:

					ilModule[i] = module330(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 340:

					ilModule[i] = module340(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 311:

					ilModule[i] = module311(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 321:

					ilModule[i] = module321(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 331:

					ilModule[i] = module331(spec, i, sameAs[i], isSameFirst[i]);

					break;

				case 341:

					ilModule[i] = module341(spec, i, sameAs[i], isSameFirst[i]);

					break;

				default:

					System.out.println("WRONG!");						

			}			

			mOut[i] = mNum;

			

			if(propertyType == 2 && isSameFirst[i] == 0 && sameAs[i] == i) 

				ilModule[i] = ilModule[i] + "LDN\t" + mOut[i] + "\r\n=\t" + spec[i][7] + "\r\n\r\n";

//			System.out.println("mOut: "+mOut[i]);

			

		}


		StringBuilder il = new StringBuilder();

		boolean flag = true;


		//向输出文件中添加每个规约的代码,并组合
		if (priority.isEmpty()) {
			for (int i = 0; i < size; i++) {

				if (isSameFirst[i] > 0) {
					if (flag) {
						il.append("priority\r\n");
					}

					flag = false;

					String[] combineControl = new String[isSameFirst[i] + 1];

					String priorityCode = "";

					int index = 0;

					combineControl[0] = mOut[i];

//					System.out.println("Please claim PRIORITY of following specifications with the same object: " + spec[i][7]);

					il.append(Integer.toString(i + 1));

					for (int j = i + 1; j < size; j++) {

						if (sameAs[j] == i) {

							index++;

							combineControl[index] = mOut[j];

							int sameIndex = j + 1;

							il.append("<" + Integer.toString(sameIndex));

						}

					}
					il.append("\r\n");
				}

			}
		}

		if (!flag) {
			return il.toString();
		}


		for (int i = 0; i < size; i++) {
			if (isSameFirst[i] > 0) {

				Scanner scan = new Scanner(priority);

				String prSe = scan.nextLine();

				int sizePr = prSe.length();

//				System.out.println("##"+isSameFirst[i]);

				String combineCode = "";

				int outNum = 0;

				String num = "";

				String tempCode = "";

				for(int k=0; k<sizePr; k++) {

					if(prSe.charAt(k) != '<' && prSe.charAt(k) != '=')

						num = num + prSe.charAt(k);

					if(prSe.charAt(k) == '<' || prSe.charAt(k) == '=' || k == sizePr - 1) {

						outNum = Integer.valueOf(num).intValue();

//						System.out.println("####    " + outNum);

						num = "";

						String mCode = "\t" + mOut[outNum-1];

//						System.out.println("---" + mCode);

						String combineType = spec[outNum-1][6];

						if(combineType.equals("2"))

							mCode = "N" + mCode;

						if(combineCode == "")

							combineCode = "LD" + mCode + "\r\n";

						else if(combineType.equals("2"))

							combineCode = combineCode + "A" + mCode + "\r\n";

						else if(combineType.equals("1") || combineType.equals("3"))

							combineCode = combineCode + "O" + mCode + "\r\n";

//						System.out.println("i:  " + i + "k:  " + k);

//						System.out.println("## "+ilModule[i]+"  **"+ilModule[outNum-1]);

						tempCode = tempCode + ilModule[outNum-1];

//						System.out.println("__ "+ilModule[i]);

						ilModule[outNum-1] = "";

					}

				}

				combineCode = combineCode + "=\t" + spec[i][7] + "\r\n\r\n";

				ilModule[i] = tempCode + combineCode;

				//il.append(combineCode);
			}
		}

		il.append("code\r\n");
		il.append("This is the IL code for the PLC program.\r\n\r\n");

		int in[] = new int[specSize];

		int map[][] = new int[specSize][specSize];

		int count = 0;

		for(int i=0; i<size; i++){

			in[i] = 0;

		}

		for(int i=0; i<size; i++){

			for(int j=0; j<size; j++){

				map[i][j] = 0;

				String obj = spec[i][7];

				String con1 = spec[j][1];

				String con2 = spec[j][2];

				char l,r;

				boolean flag1 = false;

				boolean flag2 = false;

				if(con1.contains(obj) && (con1.length() > obj.length())){

					int pos = con1.indexOf(obj);

					l = con1.charAt(pos-1);

					int len = obj.length();

					r = con1.charAt(pos+len);

//					System.out.print("LLLRRR : " + l + "    " + r);

					if((!(Character.isLowerCase(l) || Character.isUpperCase(l))) && (!(Character.isLowerCase(r) || Character.isUpperCase(r))))

						flag1 = true;

				}

				if(con1.contains(obj) && (con1.length() == obj.length()))

					flag1 = true;

				

				if(con2.contains(obj) && (con2.length() > obj.length())){

					int pos = con2.indexOf(obj);

					l = con2.charAt(pos-1);

					int len = obj.length();

					r = con2.charAt(pos+len);

//					System.out.print("LLLRRR : " + l + "    " + r);

					if((!(Character.isLowerCase(l) || Character.isUpperCase(l))) && (!(Character.isLowerCase(r) || Character.isUpperCase(r))))

						flag2 = true;

				}

				if(con2.contains(obj) && (con2.length() == obj.length()))

					flag2 = true;

					

				if((flag1 || flag2) && (i != j)){

					map[i][j] = 1;

					in[j] ++;

				}

				

			}

		}

		

		boolean process = true;

		String ilTemp = "";

		while(process){

			int temp = count;

			for(int i=0; i<size; i++){

				if(in[i] == 0){

					ilTemp = ilTemp + ilModule[i];

					count ++;

					in[i] = -1;

					for(int j=0; j<size; j++){

						if(map[i][j] == 1)

							in[j] --;

					}

				}

			}

			if(temp == count)

				process = false;

		}

		

		if(count == specSize)

			il.append(ilTemp);

		else{

			for(int i=0; i<size; i++) {

				il.append(ilModule[i]);

			}

		}		

		return il.toString();

	}

	

	//获得当前中间继电器编号

	public static String getM(String[][] spec, int i, int sameAs, int isSameFirst) {

		String M = "";

		if(sameAs == i && isSameFirst == 0 && !spec[i][6].equals("2"))

			M = spec[i][7];

		else {

			int m1 = mIndex / 10;

			int m0 = mIndex % 10;

			M = "M" + (m1 + ".") + (m0 + "");

			mIndex++;

		}

		

		return M;

	}

	

	public static String getM() {

		String M = "";

		int m1 = mIndex / 10;

		int m0 = mIndex % 10;

		M = "M" + (m1 + ".") + (m0 + "");

		mIndex++;

		return M;

	}

	

	public static String getTimer() {

		String TON = "";

		TON = "T" + tonIndex;

		tonIndex ++;

		if(tonIndex == 64)

			tonIndex = 101;

		if(tonIndex == 255)

			System.out.println("WARNING!\r\nToo many TON-Timers.");

		return TON;

	}

	

	public static String getPositive(String Q) {

		String codeQ = "";

		int size = Q.length();

		if(!Q.contains("(") && !Q.contains("!"))

			codeQ = "LD\t" + Q;

		else if(!Q.contains("("))

			codeQ = "LDN\t" + Q.substring(1, size);

		else {

			for(int i=0; i<size; i++) {

				int bracketNum = 1;

				int bracketIndex = -1;

				int modifyFlag = 0;

				

				if(Q.charAt(i) == '(')

						modifyFlag = 1;					

				

				if(modifyFlag == 1) {

							

					for(int j=i+1; j<size; j++) {

						if(Q.charAt(j) == '(')

							bracketNum ++;

						if(Q.charAt(j) == ')')

							bracketNum --;

						

						if(i>0)

							if(bracketNum == 1 && (Q.charAt(j) == '/' || Q.charAt(j) == '\\') && Q.charAt(i-1) != '(' && Q.charAt(j) != Q.charAt(i-1)) {

								modifyFlag = 0;

								break;

							}

						

						if(bracketNum == 0) {

							bracketIndex = j;

							break;

						}

					}

					

					if(modifyFlag == 1) {

						StringBuffer str = new StringBuffer(Q);

						str = str.replace(bracketIndex, bracketIndex+1, "");

						str = str.replace(i, i+1, "");

						Q = str.toString();

						i --;

						size = size - 2;

					}

					

				}

			}

			

			Stack<String> comLD = new Stack<String>();

			

			if(Q.charAt(0) != '!')

				codeQ = codeQ + "LD\t";

			else

				codeQ = codeQ + "LDN\t";

			

			for(int i=0; i<size; i++) {

				char ch = Q.charAt(i);

				String comStack = "";

				if(ch == '/' && Q.charAt(i+1) != '(' && Q.charAt(i+1) != '!' )

					codeQ = codeQ + "\r\nA\t";

				else if(ch == '/' && Q.charAt(i+1) != '(' && Q.charAt(i+1) == '!' )

					codeQ = codeQ + "\r\nAN\t";

				else if(ch == '\\' && Q.charAt(i+1) != '(' && Q.charAt(i+1) != '!' )

					codeQ = codeQ + "\r\nO\t";

				else if(ch == '\\' && Q.charAt(i+1) != '(' && Q.charAt(i+1) == '!' )

					codeQ = codeQ + "\r\nON\t";

				else if(ch == '/' && Q.charAt(i+1) == '(' && Q.charAt(i+2) != '!' ) {

					comLD.push("\r\nALD");

					codeQ = codeQ + "\r\nLD\t";

				}

				else if(ch == '/' && Q.charAt(i+1) == '(' && Q.charAt(i+2) == '!' ) {

					comLD.push("\r\nALD");

					codeQ = codeQ + "\r\nLDN\t";

				}

				else if(ch == '\\' && Q.charAt(i+1) == '(' && Q.charAt(i+2) != '!' ) {

					comLD.push("\r\nOLD");

					codeQ = codeQ + "\r\nLD\t";

				}

				else if(ch == '\\' && Q.charAt(i+1) == '(' && Q.charAt(i+2) == '!' ) {

					comLD.push("\r\nOLD");

					codeQ = codeQ + "\r\nLDN\t";

				}

				else if(ch == ')') {

					comStack = comLD.pop();

					codeQ = codeQ + comStack;

				}

				else if(ch != '!' && ch != '(')

					codeQ = codeQ + ch;

			}			

		}

		

		return codeQ;

	}

	

	public static String getPositiveMiddle(String Q) {

		String codeQ = "";

		int size = Q.length();

		if(!Q.contains("(") && !Q.contains("!"))

			codeQ = "A\t" + Q;

		else if(!Q.contains("("))

			codeQ = "AN\t" + Q.substring(1, size);

		else {			

			Q = "/(" + Q + ")";

			size = Q.length();

			

			for(int i=0; i<size; i++) {

				int bracketNum = 1;

				int bracketIndex = -1;

				int modifyFlag = 0;

				

				if(Q.charAt(i) == '(')

						modifyFlag = 1;					

				

				if(modifyFlag == 1) {

							

					for(int j=i+1; j<size; j++) {

						if(Q.charAt(j) == '(')

							bracketNum ++;

						if(Q.charAt(j) == ')')

							bracketNum --;

						

						if(i>0)

							if(bracketNum == 1 && (Q.charAt(j) == '/' || Q.charAt(j) == '\\') && Q.charAt(i-1) != '(' && Q.charAt(j) != Q.charAt(i-1)) {

								modifyFlag = 0;

								break;

							}

						

						if(bracketNum == 0) {

							bracketIndex = j;

							break;

						}

					}

					

					if(modifyFlag == 1) {

						StringBuffer str = new StringBuffer(Q);

						str = str.replace(bracketIndex, bracketIndex+1, "");

						str = str.replace(i, i+1, "");

						Q = str.toString();

						i --;

						size = size - 2;

					}

					

				}

			}

			

			Stack<String> comLD = new Stack<String>();

			

			for(int i=0; i<size; i++) {

				char ch = Q.charAt(i);

				String comStack = "";

				if(ch == '/' && Q.charAt(i+1) != '(' && Q.charAt(i+1) != '!' )

					codeQ = codeQ + "\r\nA\t";

				else if(ch == '/' && Q.charAt(i+1) != '(' && Q.charAt(i+1) == '!' )

					codeQ = codeQ + "\r\nAN\t";

				else if(ch == '\\' && Q.charAt(i+1) != '(' && Q.charAt(i+1) != '!' )

					codeQ = codeQ + "\r\nO\t";

				else if(ch == '\\' && Q.charAt(i+1) != '(' && Q.charAt(i+1) == '!' )

					codeQ = codeQ + "\r\nON\t";

				else if(ch == '/' && Q.charAt(i+1) == '(' && Q.charAt(i+2) != '!' ) {

					comLD.push("\r\nALD");

					codeQ = codeQ + "\r\nLD\t";

				}

				else if(ch == '/' && Q.charAt(i+1) == '(' && Q.charAt(i+2) == '!' ) {

					comLD.push("\r\nALD");

					codeQ = codeQ + "\r\nLDN\t";

				}

				else if(ch == '\\' && Q.charAt(i+1) == '(' && Q.charAt(i+2) != '!' ) {

					comLD.push("\r\nOLD");

					codeQ = codeQ + "\r\nLD\t";

				}

				else if(ch == '\\' && Q.charAt(i+1) == '(' && Q.charAt(i+2) == '!' ) {

					comLD.push("\r\nOLD");

					codeQ = codeQ + "\r\nLDN\t";

				}

				else if(ch == ')') {

					comStack = comLD.pop();

					codeQ = codeQ + comStack;

				}

				else if(ch != '!' && ch != '(')

					codeQ = codeQ + ch;

			}

			if(codeQ.indexOf("\r\n") == 0){

				codeQ = codeQ.replaceFirst("\r\n", "");

			}

		}

		

		return codeQ;

	}

	

	public static String getNegative(String R) {

		String codeR = "";

		int size = R.length();

		String Q = "";

		

		if(!R.contains("(") && !R.contains("!"))

			codeR = "AN\t" + R;

		else if(!R.contains("("))

			codeR = "A\t" + R.substring(1, size);

		else {

			Q = R.replaceAll("/", "//");

			Q = Q.replaceAll("\\\\", "/");

			Q = Q.replaceAll("//", "\\\\");			

			Q = "/(" + Q + ")";

			size = Q.length();

			

			for(int i=0; i<size; i++) {

				int bracketNum = 1;

				int bracketIndex = -1;

				int modifyFlag = 0;

				

				if(Q.charAt(i) == '(')

						modifyFlag = 1;					

				

				if(modifyFlag == 1) {

							

					for(int j=i+1; j<size; j++) {

						if(Q.charAt(j) == '(')

							bracketNum ++;

						if(Q.charAt(j) == ')')

							bracketNum --;

						

						if(i>0)

							if(bracketNum == 1 && (Q.charAt(j) == '/' || Q.charAt(j) == '\\') && Q.charAt(i-1) != '(' && Q.charAt(j) != Q.charAt(i-1)) {

								modifyFlag = 0;

								break;

							}

						

						if(bracketNum == 0) {

							bracketIndex = j;

							break;

						}

					}

					

					if(modifyFlag == 1) {

						StringBuffer str = new StringBuffer(Q);

						str = str.replace(bracketIndex, bracketIndex+1, "");

						str = str.replace(i, i+1, "");

						Q = str.toString();

						i --;

						size = size - 2;

					}

					

				}

			}

			

			String codeQ = "";

			Stack<String> comLD = new Stack<String>();			

			size = Q.length();

			

			for(int i=0; i<size; i++) {

				char ch = Q.charAt(i);

				String comStack = "";

				if(ch == '/' && Q.charAt(i+1) != '(' && Q.charAt(i+1) != '!' )

					codeQ = codeQ + "\r\nAN\t";

				else if(ch == '/' && Q.charAt(i+1) != '(' && Q.charAt(i+1) == '!' )

					codeQ = codeQ + "\r\nA\t";

				else if(ch == '\\' && Q.charAt(i+1) != '(' && Q.charAt(i+1) != '!' )

					codeQ = codeQ + "\r\nON\t";

				else if(ch == '\\' && Q.charAt(i+1) != '(' && Q.charAt(i+1) == '!' )

					codeQ = codeQ + "\r\nO\t";

				else if(ch == '/' && Q.charAt(i+1) == '(' && Q.charAt(i+2) != '!' ) {

					comLD.push("\r\nALD");

					codeQ = codeQ + "\r\nLDN\t";

				}

				else if(ch == '/' && Q.charAt(i+1) == '(' && Q.charAt(i+2) == '!' ) {

					comLD.push("\r\nALD");

					codeQ = codeQ + "\r\nLD\t";

				}

				else if(ch == '\\' && Q.charAt(i+1) == '(' && Q.charAt(i+2) != '!' ) {

					comLD.push("\r\nOLD");

					codeQ = codeQ + "\r\nLDN\t";

				}

				else if(ch == '\\' && Q.charAt(i+1) == '(' && Q.charAt(i+2) == '!' ) {

					comLD.push("\r\nOLD");

					codeQ = codeQ + "\r\nLD\t";

				}

				else if(ch == ')') {

					comStack = comLD.pop();

					codeQ = codeQ + comStack;

				}

				else if(ch != '!' && ch != '(')

					codeQ = codeQ + ch;

			}

			codeR = codeQ;

			if(codeR.indexOf("\r\n") == 0){

				codeR = codeR.replaceFirst("\r\n", "");

			}

		}

		

		return codeR;

	}

	

	public static String getNegativeStart(String Q) {

		String codeQ = "";

		int size = Q.length();

		if(!Q.contains("(") && !Q.contains("!"))

			codeQ = "LDN\t" + Q;

		else if(!Q.contains("("))

			codeQ = "LD\t" + Q.substring(1, size);

		else {

			

			Q = Q.replaceAll("/", "//");

			Q = Q.replaceAll("\\\\", "/");

			Q = Q.replaceAll("//", "\\\\");

			size = Q.length();

			

			for(int i=0; i<size; i++) {

				int bracketNum = 1;

				int bracketIndex = -1;

				int modifyFlag = 0;

				

				if(Q.charAt(i) == '(')

						modifyFlag = 1;					

				

				if(modifyFlag == 1) {

							

					for(int j=i+1; j<size; j++) {

						if(Q.charAt(j) == '(')

							bracketNum ++;

						if(Q.charAt(j) == ')')

							bracketNum --;

						

						if(i>0)

							if(bracketNum == 1 && (Q.charAt(j) == '/' || Q.charAt(j) == '\\') && Q.charAt(i-1) != '(' && Q.charAt(j) != Q.charAt(i-1)) {

								modifyFlag = 0;

								break;

							}

						

						if(bracketNum == 0) {

							bracketIndex = j;

							break;

						}

					}

					

					if(modifyFlag == 1) {

						StringBuffer str = new StringBuffer(Q);

						str = str.replace(bracketIndex, bracketIndex+1, "");

						str = str.replace(i, i+1, "");

						Q = str.toString();

						i --;

						size = size - 2;

					}

					

				}

			}

			

			Stack<String> comLD = new Stack<String>();

			

			if(Q.charAt(0) != '!')

				codeQ = codeQ + "LDN\t";

			else

				codeQ = codeQ + "LD\t";

			

			for(int i=0; i<size; i++) {

				char ch = Q.charAt(i);

				String comStack = "";

				if(ch == '/' && Q.charAt(i+1) != '(' && Q.charAt(i+1) != '!' )

					codeQ = codeQ + "\r\nAN\t";

				else if(ch == '/' && Q.charAt(i+1) != '(' && Q.charAt(i+1) == '!' )

					codeQ = codeQ + "\r\nA\t";

				else if(ch == '\\' && Q.charAt(i+1) != '(' && Q.charAt(i+1) != '!' )

					codeQ = codeQ + "\r\nON\t";

				else if(ch == '\\' && Q.charAt(i+1) != '(' && Q.charAt(i+1) == '!' )

					codeQ = codeQ + "\r\nO\t";

				else if(ch == '/' && Q.charAt(i+1) == '(' && Q.charAt(i+2) != '!' ) {

					comLD.push("\r\nALD");

					codeQ = codeQ + "\r\nLDN\t";

				}

				else if(ch == '/' && Q.charAt(i+1) == '(' && Q.charAt(i+2) == '!' ) {

					comLD.push("\r\nALD");

					codeQ = codeQ + "\r\nLD\t";

				}

				else if(ch == '\\' && Q.charAt(i+1) == '(' && Q.charAt(i+2) != '!' ) {

					comLD.push("\r\nOLD");

					codeQ = codeQ + "\r\nLDN\t";

				}

				else if(ch == '\\' && Q.charAt(i+1) == '(' && Q.charAt(i+2) == '!' ) {

					comLD.push("\r\nOLD");

					codeQ = codeQ + "\r\nLD\t";

				}

				else if(ch == ')') {

					comStack = comLD.pop();

					codeQ = codeQ + comStack;

				}

				else if(ch != '!' && ch != '(')

					codeQ = codeQ + ch;

			}			

		}

		

		return codeQ;

	}

	

	

	public static String module110(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		mNum = getM(spec, i, sameAs, isSameFirst);

		code = "LD\tSM0.0\r\n=\t" + mNum + "\r\n\r\n";

		return code;

	}

	

	public static String module120(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String Q = getPositive(spec[i][1]);

		mNum = getM(spec, i, sameAs, isSameFirst);

		code = Q + "\r\nO\t" + mNum + "\r\n=\t" + mNum +"\r\n\r\n"; 

		return code;

	}

	

	public static String module130(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String Q = getPositive(spec[i][1]);

		String R = getNegative(spec[i][2]);

		mNum = getM(spec, i, sameAs, isSameFirst);

		code = Q + "\r\nO\t" + mNum + "\r\n" + R + "\r\n=\t" + mNum +"\r\n\r\n"; 

		return code;

	}

	

	public static String module140(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String Q = getPositive(spec[i][1]);

		mNum = getM(spec, i, sameAs, isSameFirst);

		code = Q + "\r\n=\t" + mNum + "\r\n\r\n";

		return code;

	}



	public static String module112(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String ton = getTimer();

		mNum = getM(spec, i, sameAs, isSameFirst);

		code = "LD\tSM0.1\r\nO\t" + mNum + "\r\nAN\t" + ton + "\r\n=\t" + mNum + "\r\n\r\nLD\t" + mNum + "\r\nTON\t" + ton + ", " + spec[i][4] + "\r\n\r\n";

		return code;

	}



	public static String module113(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String ton1 = getTimer();

		String ton2 = getTimer();

		String m = getM();

		mNum = getM(spec, i, sameAs, isSameFirst);

		int t = Integer.valueOf(spec[i][4]).intValue() - Integer.valueOf(spec[i][3]).intValue();

		code = "LD\tSM0.1\r\nO\t" + m + "\r\nAN\t" + ton2 + "\r\n=\t" + m + "\r\n\r\nLD\t" + m + "\r\nTON\t" + ton1 + ", " + spec[i][3] + "\r\n\r\nLD\t" + ton1 + "\r\nTON\t" + ton2 + ", "+ t + "\r\n\r\nLD\t" + ton1 + "\r\n=\t" +mNum + "\r\n\r\n";

		return code;

	}



	public static String module114(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String ton = getTimer();

		String m = getM();

		mNum = getM(spec, i, sameAs, isSameFirst);

		code = "LD\tSM0.1\r\nO\t" + m + "\r\n=\t" + m + "\r\n\r\nLD\t" + m + "\r\nTON\t" + ton + ", " + spec[i][3] + "\r\n\r\nLD\t" + ton + "\r\n=\t" + mNum + "\r\n\r\n";

		return code;

	}



	public static String module122(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String Q = getPositive(spec[i][1]);

		String ton =getTimer();

		mNum = getM(spec, i, sameAs, isSameFirst);		

		code = Q + "\r\nO\t" + mNum + "\r\nAN\t" + ton + "\r\n=\t" + mNum + "\r\n\r\nLD\t" + mNum + "\r\nTON\t" + ton + ", " + spec[i][4] + "\r\n\r\n";

		return code;

	}



	public static String module123(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String Q = getPositive(spec[i][1]);

		String ton1 =getTimer();

		String ton2 =getTimer();

		String m = getM();

		mNum = getM(spec, i, sameAs, isSameFirst);

		int t = Integer.valueOf(spec[i][4]).intValue() - Integer.valueOf(spec[i][3]).intValue();

		code = Q + "\r\nO\t" + m + "\r\nAN\t" + ton2 + "\r\n=\t" + m + "\r\n\r\nLD\t" + m + "\r\nTON\t" + ton1 + ", " + spec[i][3] + "\r\n\r\nLD\t" + ton1 + "\r\nTON\t" + ton2 + ", " + t + "\r\n\r\nLD\t" + ton1 + "\r\n=\t" +mNum + "\r\n\r\n";

		return code;

	}



	public static String module124(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String ton = getTimer();

		String Q = getPositive(spec[i][1]);

		mNum = getM(spec, i, sameAs, isSameFirst);

		code = Q + "\r\nO\t" + mNum + "\r\n=\t" + mNum + "\r\n\r\nLD\t" + mNum + "\r\nTON\t" + ton + ", " + spec[i][3] + "\r\n\r\nLD\t" + ton + "\r\n=\t" + mNum + "\r\n\r\n";

		return code;

	}



	public static String module132(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String Q = getPositive(spec[i][1]);

		String R = getNegative(spec[i][2]);

		String ton =getTimer();

		mNum = getM(spec, i, sameAs, isSameFirst);

		code = Q + "\r\nO\t" + mNum + "\r\n" + R + "\r\nAN\t" + ton + "\r\n=\t" + mNum + "\r\n\r\nLD\t" + mNum + "\r\nTON\t" + ton + ", " + spec[i][4] + "\r\n\r\n";

		return code;

	}



	public static String module133(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String Q = getPositive(spec[i][1]);

		String R = getNegative(spec[i][2]);

		String ton1 =getTimer();

		String ton2 =getTimer();

		String m = getM();

		mNum = getM(spec, i, sameAs, isSameFirst);

		int t = Integer.valueOf(spec[i][4]).intValue() - Integer.valueOf(spec[i][3]).intValue();

		code = Q + "\r\nO\t" + m + "\r\n" + R + "\r\nAN\t" + ton2 + "\r\n=\t" + m + "\r\n\r\nLD\t" + m + "\r\nTON\t" + ton1 + ", " + spec[i][3] + "\r\n\r\nLD\t" + ton1 + "\r\nTON\t" + ton2 + ", " + t + "\r\n\r\nLD\t" + ton1 + "\r\n=\t" +mNum + "\r\n\r\n";

		return code;

	}



	public static String module134(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String ton = getTimer();

		String Q = getPositive(spec[i][1]);

		String R = getNegative(spec[i][2]);

		String m = getM();

		mNum = getM(spec, i, sameAs, isSameFirst);

		code = Q + "\r\nO\t" + m + "\r\n" + R + "\r\n=\t" + m + "\r\n\r\nLD\t" + m + "\r\nTON\t" + ton + ", " + spec[i][3] + "\r\n\r\nLD\t" + ton + "\r\n=\t" + mNum + "\r\n\r\n";

		return code;

	}



	public static String module135(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String Q = getPositive(spec[i][1]);

		String R = getPositive(spec[i][2]);

		String ton =getTimer();

		String m = getM();

		mNum = getM(spec, i, sameAs, isSameFirst);

		code = Q + "\r\nO\t" + mNum + "\r\nAN\t" + ton + "\r\n=\t" + mNum + "\r\n\r\n" + R + "\r\nO\t" + m + "\r\nA\t" + mNum + "\r\n=\t" + m + "\r\n\r\nLD\t" + m + "\r\nTON\t" + ton + ", " + spec[i][5] + "\r\n\r\n";

		return code;

	}



	public static String module136(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String Q = getPositive(spec[i][1]);

		String R = getPositive(spec[i][2]);

		String ton1 =getTimer();

		String ton2 =getTimer();

		String m0 = getM();

		String m1 = getM();

		mNum = getM(spec, i, sameAs, isSameFirst);

		code = Q + "\r\nO\t" + m0 + "\r\nAN\t" + ton2 + "\r\n=\t" + m0 + "\r\n\r\nLD\t" + m0 + "\r\nTON\t" + ton1 + ", " + spec[i][3] + "\r\n\r\nLD\t" + ton1 + "\r\n=\t" + mNum + "\r\n\r\n" + R + "\r\nO\t" + m1 + "\r\nA\t" + m0 + "\r\n=\t" + m1 + "\r\n\r\nLD\t" + m1 + "\r\nTON\t" + ton2 + ", " + spec[i][5] + "\r\n\r\n";

		return code;

	}



	public static String module137(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";		

		String Q = getPositive(spec[i][1]);

		String R = getNegative(spec[i][2]);

		String m = getM();

		String ton = getTimer();

		mNum = getM(spec, i, sameAs, isSameFirst);

		code = Q + "\r\nO\t" + m + "\r\n" + R + "\r\n=\t" + m + "\r\n\r\nLD\t" + m + "\r\nTON\t" + ton + ", " + spec[i][3] + "\r\n\r\nLD\t" + ton + "\r\n=\t" + mNum + "\r\n\r\n";

		return code;

	}



	public static String module142(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String Q = getPositive(spec[i][1]);

		String ton = getTimer();

		mNum = getM(spec, i, sameAs, isSameFirst);

		code = Q + "\r\nTON\t" + ton + ", " + spec[i][4] + "\r\n\r\n" + Q + "\r\nAN\t" + ton + "\r\n=\t" + mNum + "\r\n\r\n";

		return code;

	}



	public static String module143(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String Q = getPositive(spec[i][1]);

		String ton1 = getTimer();

		String ton2 = getTimer();

		mNum = getM(spec, i, sameAs, isSameFirst);

		int t = Integer.valueOf(spec[i][4]).intValue() - Integer.valueOf(spec[i][3]).intValue();

		code = Q + "\r\nTON\t" + ton1 + ", " + spec[i][3] + "\r\n\r\nLD\t" + ton1 + "\r\nTON\t" + ton2 + ", " + t + "\r\n\r\nLD\t" + ton1 + "\r\nAN\t" + ton2 + "\r\n=\t" + mNum + "\r\n\r\n"; 

		return code;

	}



	public static String module144(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String Q = getPositive(spec[i][1]);

		String ton = getTimer();

		mNum = getM(spec, i, sameAs, isSameFirst);

		code = Q + "\r\nTON\t" + ton + ", " + spec[i][3] + "\r\n\r\nLD\t" + ton + "\r\n=\t" + mNum +"\r\n\r\n";

		return code;

	}



	public static String module145(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String Q = getPositive(spec[i][1]);

		String Qn = getNegativeStart(spec[i][1]);

		String ton = getTimer();

		mNum = getM(spec, i, sameAs, isSameFirst);

		code = Q + "\r\nO\t" + mNum + "\r\nAN\t" + ton + "\r\n=\t" + mNum + "\r\n\r\n" + Qn + "\r\nA\t" + mNum + "\r\nTON\t" + ton + ", " + spec[i][5] + "\r\n\r\n";

		return code;

	}



	public static String module146(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String Q = getPositive(spec[i][1]);

		String Qn = getNegativeStart(spec[i][1]);

		String ton1 = getTimer();

		String ton2 = getTimer();

		mNum = getM(spec, i, sameAs, isSameFirst);

		code = Q + "\r\nTON\t" + ton1 + ", " + spec[i][3] + "\r\n\r\nLD\t" + ton1 + "\r\nO\t" + mNum + "\r\nAN\t" + ton2 + "\r\n=\t" + mNum + "\r\n\r\n" + Qn + "\r\nA\t" + mNum + "\r\nTON\t" + ton2 + ", " + spec[i][5] + "\r\n\r\n";

		return code;

	}



	public static String module147(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String Q = getPositive(spec[i][1]);

		String ton = getTimer();

		mNum = getM(spec, i, sameAs, isSameFirst);

		code = Q + "\r\nTON\t" + ton + ", " + spec[i][3] + "\r\n\r\nLD\t" + ton + "\r\n=\t" + mNum + "\r\n\r\n";

		return code;

	}



	public static String module310(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		mNum = getM(spec, i, sameAs, isSameFirst);

		code = "LD\tSM0.1\r\n=\t" + mNum+ "\r\n\r\n"; 

		return code;

	}



	public static String module320(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String Q = getPositive(spec[i][1]);

		String m = getM();

		mNum = getM(spec, i, sameAs, isSameFirst);

		code = Q + "\r\nAN\t" + m + "\r\n=\t" + mNum + "\r\n\r\nLD\t" + mNum + "\r\nO\t" + m + "\r\n=\t" + m + "\r\n\r\n";

		return code;

	}



	public static String module330(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String Q = getPositive(spec[i][1]);

		String R = getNegative(spec[i][2]);

		String m0 = getM();

		String m1 = getM();

		mNum = getM(spec, i, sameAs, isSameFirst);

		code = Q + "\r\nO\t" + m0 + "\r\n" + R + "\r\n=\t" + m0 + "\r\n\r\nLD\t" + m0 + "\r\nAN\t" + m1 + "\r\n=\t" + mNum + "\r\n\r\nLD\t" + mNum + "\r\nO\t" + m1 + "\r\nA\t" + m0 + "\r\n=\t" + m1 + "\r\n\r\n";

		return code;

	}



	public static String module340(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String Q = getPositive(spec[i][1]);

		String Qm = getPositiveMiddle(spec[i][1]);

		String m = getM();

		mNum = getM(spec, i, sameAs, isSameFirst);

		code = Q + "\r\nAN\t" + m + "\r\n=\t" + mNum + "\r\n\r\nLD\t" + mNum + "\r\nO\t" + m + "\r\n" + Qm + "\r\n=\t" + m +"\r\n\r\n";

		return code;

	}



	public static String module311(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String m = getM();

		mNum = getM(spec, i, sameAs, isSameFirst);

		String ton = getTimer();

		code = "LD\tSM0.1\r\nO\t" + m + "\r\nAN\t" + mNum + "\r\n=\t" + m + "\r\n\r\nLD\t" + m + "\r\nTON\t" + ton + ", " + spec[i][3] + "\r\n\r\nLD\t" + ton + "\r\n=\t" + mNum + "\r\n\r\n";

		return code;

	}



	public static String module321(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String Q = getPositive(spec[i][1]);

		String m = getM();

		String ton = getTimer();

		mNum = getM(spec, i, sameAs, isSameFirst);

		code = Q + "\r\nO\t" + m + "\r\nAN\t" + mNum + "\r\n=\t" + m + "\r\n\r\nLD\t" + m + "\r\nTON\t" + ton + ", " + spec[i][3] + "\r\n\r\nLD\t" + ton + "\r\n=\t" + mNum + "\r\n\r\n";

		return code;

	}



	public static String module331(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String Q = getPositive(spec[i][1]);

		String R = getNegative(spec[i][2]);

		String m = getM();

		String ton = getTimer();

		mNum = getM(spec, i, sameAs, isSameFirst);

		code = Q + "\r\nO\t" + m + "\r\nAN\t" + mNum + "\r\n" + R + "\r\n=\t" + m + "\r\n\r\nLD\t" + m + "\r\nTON\t" + ton + ", " + spec[i][3] + "\r\n\r\nLD\t" + ton + "\r\n=\t" + mNum + "\r\n\r\n";

		return code;

	}



	public static String module341(String[][] spec, int i, int sameAs, int isSameFirst) {

		String code = "";

		String Q = getPositive(spec[i][1]);

		String ton = getTimer();

		mNum = getM(spec, i, sameAs, isSameFirst);

		code = Q + "\r\nAN\t" + mNum + "\r\nTON\t" + ton + ", " + spec[i][3] + "\r\n\r\nLD\t" + ton + "\r\n=\t" + mNum + "\r\n\r\n";

		return code;

	}

	



}

