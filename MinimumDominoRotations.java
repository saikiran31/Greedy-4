class MinimumDominoRotations {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int target =1;
        for(int i=0;i<tops.length;i++)
        {
            int top = tops[i];
            map.put(top,map.getOrDefault(top, 0)+1);
            if(map.get(top)>= tops.length)
            {target=top;
            break;
            }
 
 
        }
        for(int i=0;i<bottoms.length;i++)
        {
            int bottom = bottoms[i];
            map.put(bottom,map.getOrDefault(bottom,0)+1);
            if(map.get(bottom)>= bottoms.length)
            {target=bottom;
            break;
            }
 
 
        }
        int aRotations =0;
         int bRotations =0;
         for(int i=0;i<tops.length;i++)
        {
            int top = tops[i];
            int bottom = bottoms[i];
            if(top!=target && bottom!=target)
            return -1;
            if(top!=target)
            aRotations++;
            if(bottom!=target)
            bRotations++;
        }
        return Math.min(aRotations,bRotations);
    }
 }
 
 //tc: O(n)
 //sc: O(1)
 