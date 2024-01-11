public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans=new ArrayList<>();
        
        Queue<Integer> q=new LinkedList<>();
        boolean arr[]=new boolean[V];
        
        q.add(0);
        while(!q.isEmpty())
        {
            int curr=q.remove();
            if(arr[curr]==false)
            {
                ans.add(curr);
                arr[curr]=true;
                for(int i=0;i<adj.get(curr).size();i++)
                {
                    int e =adj.get(curr).get(i);
                    
                    q.add(e);
                }
            }
        }
        return ans;
