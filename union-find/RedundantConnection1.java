//link to question: https://leetcode.com/problems/redundant-connection/

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        DSU dsu=new DSU(n);
        for(int[] e:edges){
            int u=e[0]-1;
            int v=e[1]-1;//0 based indexing
            if(!dsu.union(u,v))return new int[]{u+1,v+1};
        }
        return new int[]{-1,-1};
    }
}
class DSU{
    int[] parent,size;
    DSU(int n){
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    int find(int x){
        if(parent[x]==x)return x;
        return find(parent[x]);
    }
    boolean union(int a,int b){
        int pa=find(a),pb=find(b);
        if(pa==pb)return false;
        else if(size[pa]>=size[pb]){
            parent[pb]=pa;
            size[pa]+=size[pb];
        }
        else if(size[pb]>size[pa]){
            parent[pa]=pb;
            size[pb]+=size[pa];
        }
        return true;
    }
}
