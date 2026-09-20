class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length == 0){
            return 0;
        }
        double[][] pairs= new double[position.length][2];
        for(int i=0; i<position.length; i++){
            pairs[i][0] = (position[i]);
            pairs[i][1] = (target-position[i])/(speed[i]*1.0) ;
        }
       Arrays.sort(pairs, (a,b)->Double.compare(b[0], a[0]));

    int fleets=1;
    int fleetPos = 0;
    for(int i=1; i<position.length; i++){
        if(pairs[i][1]> pairs[fleetPos][1]){
            fleets++;
            fleetPos = i;
        }
    }
    return fleets;
    }
}
// after 1
// 4 6
// after 2
// 7 8
// after 3
// 10 10


// after 1
// 6318
// after 2
// 8529
// after 3
// 10 7 3 10