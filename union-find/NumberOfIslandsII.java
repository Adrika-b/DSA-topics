class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        DSU dsu=new DSU(m*n);
        boolean[][] land=new boolean[m][n];
        int[][] dirs={{-1,0},{0,-1},{0,1},{1,0}};
        List<Integer> ans=new ArrayList<>();
        int count=0;
        for(int[] p:positions){
            
                int x=p[0];
                int y=p[1];
                int id1=x*n+y;
                if(land[x][y]){
                    ans.add(count);
                    continue;}
                land[x][y]=true;
                count++;
                for(int[] d:dirs){
                    int nx=x+d[0];
                    int ny=y+d[1];
                    if(nx>=0 && ny>=0 && nx<m && ny<n && land[nx][ny]){
                        int id2=nx*n+ny;
                        if(dsu.union(id1,id2))
                        count--;
                        
                    }
                }
                
                ans.add(count);
            }
        
        return ans;
    }
}
class DSU{
    int[] p, size;
    DSU(int n){
        
         p=new int[n];
     size=new int[n];
        for(int i=0;i<n;i++){
            p[i]=i;
            size[i]=1;
        }
    }
    int find(int x){
        if(p[x]!=x)p[x]=find(p[x]);
        return p[x];
    }
    boolean union(int a,int b){
        int pa=find(a),pb=find(b);
        if(pa==pb)return false;
        else if(size[pa]>size[pb]){
            p[pb]=pa;
            size[pa]+=size[pb];
        }
        else if(size[pb]>size[pa]){
            p[pa]=pb;
            size[pb]+=size[pa];
        }
        else{
            p[pb]=pa;
            size[pa]+=size[pb];
        }
        return true;
    }
}
