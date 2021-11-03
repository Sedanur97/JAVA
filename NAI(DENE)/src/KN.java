//import java.io.File;
//import java.io.IOException;
//import java.util.*;
//
//public class KN {
//
//    public static void main(String[] args) throws IOException {
//
//        int k = args.length > 0 ? Integer.parseInt(args[0]) : 3;
//        File trainData = args.length > 1 ? new File(args[1]) : new File("/Users/mehlikabilgicli/IdeaProjects/NAI(DENE)/src/iris.csv");
//        File testData = args.length > 2 ? new File(args[2]) : new File("/Users/mehlikabilgicli/IdeaProjects/NAI(DENE)/src/iris.test.csv");
//
//        //creating a trainSet
//        List<Irys> trainSet = new ArrayList<>();
//        Scanner scanner = new Scanner(trainData);
//        while (scanner.hasNext()) {
//            String[] arr = scanner.nextLine().split(",");
//            trainSet.add(new Irys(Double.parseDouble(arr[0]), Double.parseDouble(arr[1]),
//                    Double.parseDouble(arr[2]), Double.parseDouble(arr[3]), arr[4]));
//        }
//
//        scanner = new Scanner(testData);
//        int correctResult = 0, wrongResult = 0;
//        while (scanner.hasNext()) {
//            String line = scanner.nextLine();
//
//            int i = findCorrect(k, trainSet, line);
//            if (i == 0)
//                wrongResult++;
//            if (i == 1)
//                correctResult++;
//        }
//
//        System.out.println("For given data the accuracy is " + correctResult * 100 / (correctResult + wrongResult) + "%");
//
//        scanner = new Scanner(System.in);
//        while(true) {
//            System.out.println("\nInsert vector. Separate numbers with comma.");
//            String line = scanner.nextLine() + ",.";
//            System.out.println(returnName(k, trainSet, line));
//        }
//    }
//
//    static int findCorrect(int k, List<Irys> trainSet, String line) {
//        //i will return 0 if the result is incorrect, 1 if it is correct, and 2 if there are two options with same probability
//
//        //I create a map with type as a key and count how many i have of it
//        Map<String, Integer> results = resultMap(k, trainSet, line);
//
//        String winner = "";
//        int winnerRate = 0;
//
//        //i choose one one with biggest number of occurrences
//        for(String name : results.keySet()) {
//            if(results.get(name) > winnerRate) {
//                winner = name;
//                winnerRate = results.get(name);
//            }
//        }
//
//        results.remove(winner);
//
//        //and if there are more than one with same number of occurrences then i remove this point
//        for(String name : results.keySet()) {
//            if(results.get(name) == winnerRate) {
//                return 2;
//            }
//        }
//
//        if(winner.equals(line.split(",")[4])) {
//            return 1;
//        }
//
//        return 0;
//    }
//
//    static List<String> returnName (int k, List<Irys> trainSet, String line) {
//        Map<String, Integer> results = resultMap(k, trainSet, line);
//        String winner = "";
//        int winnerRate = 0;
//        List<String> list = new ArrayList<>();
//
//        //i choose one one with biggest number of occurrences
//        for(String name : results.keySet()) {
//            if(results.get(name) > winnerRate) {
//                winner = name;
//                winnerRate = results.get(name);
//            }
//        }
//        list.add(winner);
//        results.remove(winner);
//
//        //and if there are more than one with same number of occurrences then i remove this point
//        for(String name : results.keySet()) {
//            if(results.get(name) == winnerRate) {
//                list.add(name);
//            }
//        }
//
//        return list;
//    }
//
//    static Map<String, Integer> resultMap(int k, List<Irys> trainSet, String line) {
//        String[] arr = line.split(",");
//
//        //current line from the test
//        Irys irys = new Irys(Double.parseDouble(arr[0]), Double.parseDouble(arr[1]), Double.parseDouble(arr[2]),
//                Double.parseDouble(arr[3]));
//
//        //map, where I store k number of the closest points to current point
//        Map<Irys, Double> kFinal = new HashMap<>();
//
//        //for each point in training set
//        for(Irys i : trainSet) {
//            //I count how far are they
//            double odleglosc = Math.sqrt((Math.pow((irys.vector[0] - i.vector[0]), 2))
//                    + (Math.pow((irys.vector[1] - i.vector[1]), 2))
//                    + (Math.pow((irys.vector[2] - i.vector[2]), 2))
//                    + (Math.pow((irys.vector[3] - i.vector[3]), 2)));
//
//            //if in kFinal is less than k points I just add current one
//            boolean empty = false;
//            if (kFinal.size() < k) {
//                empty = true;
//                kFinal.put(i, odleglosc);
//            }
//
//            //if in kFinal is enough points I add current one and delete the biggest
//            if (!empty) {
//                kFinal.put(i, odleglosc);
//                List<Irys> toRemove = new ArrayList<>();
//
//                for (Irys entry : kFinal.keySet()) {
//                    if (kFinal.get(entry) > odleglosc) {
//                        toRemove.add(entry);
//                    }
//                }
//
//                for (Irys removeIrys : toRemove) {
//                    kFinal.remove(removeIrys);
//                }
//            }
//        }
//
//        //I create a map with type as a key and count how many i have of it
//        Map<String, Integer> results = new HashMap<>();
//        for(Irys i : kFinal.keySet()) {
//            if(results.containsKey(i.gatunek)) {
//                results.replace(i.gatunek, (results.get(i.gatunek)+1));
//            } else {
//                results.put(i.gatunek, 1);
//            }
//        }
//        return results;
//    }
//
//}
//
//class Irys {
//    double[] vector = new double[4];
//    String gatunek = "";
//
//    Irys(double a, double b, double c, double d, String gat) {
//        vector[0] = a; vector[1] = b; vector[2] = c; vector[3] = d;
//        gatunek = gat;
//    }
//
//    Irys(double a, double b, double c, double d) {
//        vector[0] = a; vector[1] = b; vector[2] = c; vector[3] = d;
//    }
//}
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;




public class KN {

    String textfile ="C:\\Users\\sedan\\IdeaProjects\\NAI(DENE)\\src\\iris.csv";
    String trainfile ="C:\\Users\\sedan\\IdeaProjects\\NAI(DENE)\\src\\iris.test.csv";

    double[] data;
    String LType;
    int k;
    private String flower;
    private int attribute=0;


    List<Distance> distances =new ArrayList<>();
    List<String> flowersResult =new ArrayList<>();
    Scanner scanner = new Scanner(System.in);


    public KN (double[] data, String LType) {
        this.LType = LType;
        this.data = data;
    }


    public static List<KN> loadDataTrainingSet(String Path) throws FileNotFoundException {
        List<KN> list = new ArrayList<>();
        Scanner input = new Scanner(new File(Path));
        List<String> flowersResult =new ArrayList<>();


        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] row = line.split(",");
            double[] x = new double[4];
            for (int i = 0; i < row.length - 1; i++) {

                //    x[0] = Double.parseDouble(row[0]);
                //    x[1] = Double.parseDouble(row[1]);
                //    x[2] = Double.parseDouble(row[2]);
                x[i] = Double.parseDouble(row[i]);
            }
            list.add(new KN(x, row[4]));
        }
        input.close();
        return list;
    }


    public KN( List<KN> test, List<KN> train) {
        List<KN> testList = new ArrayList<>();
        testList = test;
        double count = 0;
        int k;



        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("please enter k :");

        k=scanner.nextInt();

        USER();

        flowersResult.clear();

        // for labels
        List<KN> labelList = new ArrayList();
        labelList = train;
        // for distances
        // List<Result> dists = new ArrayList();
        // iterate over each row of testList
        for (int i = 0; i < testList.size(); i++) {
            List<Result> dists = new ArrayList();
            for (KN label : labelList) {
                double dist = 0;
                for (int j = 0; j < label.data.length; j++) {
                    dist = dist + Math.pow(label.data[j] - testList.get(i).data[j], 2);
                }
                double distance = Math.sqrt(dist);
                dists.add(new Result(distance, label.LType));
            }

            //shows the all flowers here
            Collections.sort(dists, new DistComp());
            int virg = 0;
            int versi = 0;
            int seto = 0;
            for (int g = 0; g < k; g++) {
                if (dists.get(g).LType.equals("Iris-virginica")) {
                    virg++;
                } else if (dists.get(g).LType.equals("Iris-versicolor")) {
                    versi++;
                } else if (dists.get(g).LType.equals("Iris-setosa")) {
                    seto++;
                }
            }
            //System.out.println(virg + " " + versi + " " + seto);
            if (virg > versi && virg > seto) {
                //System.out.print("Iris-virginica      ");
                if(!testList.get(i).LType.equals("Iris-virginica")){
                    count++;
                }
            } else if (versi > virg && versi > seto) {
                //System.out.print("Iris-versicolor     ");
                if(!testList.get(i).LType.equals("Iris-versicolor")){
                    count++;
                }
            } else if (seto > virg && seto > versi) {
                //System.out.print("Iris-setosa         ");
                if(!testList.get(i).LType.equals("Iris-setosa")){
                    count++;
                }
            } else if (virg == versi || virg == seto || versi == seto) {
                //System.out.print("Too many spieciesrealte to this object");
                count++;
            }
            //System.out.println(testList.get(i).LType + " ");

        }
        //calculate the k
        count = Math.floor(((30 - count)/30 * 100) * 100) / 100;
        System.out.println("Accuracy: "+ count);

    }

    //read the iris files
    List<String> readData (String filee){
        List<String> tmp = new ArrayList<>();
        File file = new File(filee);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                tmp.add(st);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("io exception");
        }

        return tmp;

    }
    public double[] data(String a){//we get flowers names and numbers for each row

        String[] sp =a.split(",");
        List<String> removeFirst =new ArrayList<>();
        removeFirst.addAll(Arrays.asList(sp));
        removeFirst.remove(0);
        flower=removeFirst.get(removeFirst.size()-1);//getting flower name

        double[] att =new double[removeFirst.size()-1];
        for (int i = 0; i < att.length; i++) {
            att[i] =Double.parseDouble(removeFirst.get(i));//getting number belongs to flower
        }
        return att;
    }

    // Calculate distance from textfile
    public void DistanceTextFile(double[] attributes){

        for (int j = 0; j < readData(textfile).size(); j++) {
            double[] trainingattributes =data(readData(textfile).get(j));
            double euclid =euclidean(attributes,trainingattributes);
            distances.add(new Distance(euclid,flower));

        }
        sorting(distances);
    }

    public double euclidean(double[] first ,double[] second){//we calculate the distance here
        double sum =0;
        for (int i = 0; i <attribute; i++) {
            double power =Math.pow(first[i] -second[i],2);
            sum+=power;

        }
        return Math.sqrt(sum);
    }





    //this method connecting with distanceTexfile method
    //when i take the vectores from user it caolculate in distance class and DistanceTextFile method
    public void sorting(List<Distance> list ){

        distances = list.stream()
                .sorted()
                .limit(k)
                .collect(Collectors.toList());

        int countIrVi = 0;
        int countIrVer = 0;
        int countIrSer = 0;
        for(Distance i : distances){
            if(i.getFlower().equals("Iris-virginica") ){
                countIrVi++;
            }
            if(i.getFlower().equals("Iris-versicolor") ){
                countIrVer++;
            }
            if(i.getFlower().equals("Iris-setosa") ){
                countIrSer++;
            }
        }

        if(countIrVi > countIrVer && countIrVi > countIrSer){
            flowersResult.add("Iris-virginica");
        }
        else if(countIrVer > countIrVi && countIrVer > countIrSer){
            flowersResult.add("Iris-versicolor");
        }
        else {
            flowersResult.add("Iris-setosa");

        }


    }


    public void USER(){


        System.out.println();

        while(true){
            System.out.println("Enter some vectors with space (example: 2.4 3 4.2 8 1.9) ");
            System.out.println("OR");
            System.out.println("Write 'stop' to see Accuracy and exit");
            try {
                String input = scanner.nextLine();
                if (input.equals("stop")) {

                    break;
                }

                String[] str = split(input);
                double[] userAttributes = new double[str.length];
                for (int i = 0; i < str.length; i++) {
                    userAttributes[i] = Double.parseDouble(str[i]);
                }

                DistanceTextFile(userAttributes);
                distances.clear();
                System.out.println();
                System.out.println("your flower is : " + flowersResult.get(0));
                flowersResult.clear();
            }catch (Exception e){
                System.out.println();
                System.err.println("Please enter a valid input!");
            }
        }


    }

    public String[] split(String a){
        return a.split("\\s+");

    }
    public static void main(String [] args) throws InterruptedException, FileNotFoundException {

        KN knn = new KN( loadDataTrainingSet("C:\\Users\\sedan\\IdeaProjects\\NAI(DENE)\\src\\iris.test.csv"),
                loadDataTrainingSet("C:\\Users\\sedan\\IdeaProjects\\NAI(DENE)\\src\\iris.csv"));



    }
}



