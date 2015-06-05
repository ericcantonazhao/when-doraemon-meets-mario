package Util;


import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.io.DataInputStream;
import java.io.InputStream;

public class ReadMap
{

    public ReadMap()
    {
    }

    public static int[][] ReadMap(Context context, String path)
    {
        int map[][] = (int[][])null;
        try
        {
            InputStream in = context.getResources().getAssets().open(path);
            DataInputStream dis = new DataInputStream(in);
            int row = dis.readInt();
            int col = dis.readInt();
            map = new int[row][col];
            for(int i = 0; i < map.length; i++)
            {
                for(int j = 0; j < map[i].length; j++)
                    map[i][j] = dis.readInt();

            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return map;
    }
}
