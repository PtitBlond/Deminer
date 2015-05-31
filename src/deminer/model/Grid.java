package deminer.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Bruno Buiret, Thomas Arnaud
 */
public class Grid
{
    /**
     * Grid's columns number.
     */
    protected final int cols;
    
    /**
     * Grid's rows number.
     */
    protected final int rows;
    
    /**
     * Grid itself.
     */
    protected Cell[][] cells;
    
    /**
     * Map used to get the cell's position from the cell itself.
     */
    protected Map<Cell, Point> cellsMap;
    
    /**
     * Creates a new grid model.
     * 
     * @param cells
     * @param cols Grid's columns number.
     * @param rows Grid's rows number.
     * @param cellsMap
     */
    public Grid(Cell[][] cells, int cols, int rows, Map<Cell, Point> cellsMap)
    {
        this.cols = cols;
        this.rows = rows;
        this.cells = cells;
        this.cellsMap = cellsMap;
    }
    
    /**
     * Gets a cell's list of neighbours.
     * 
     * @param cell Reference to the cell.
     * @return Cell's list of neighbours.
     */
    public List<Cell> getNeighbours(Cell cell)
    {
        List<Cell> neighbours = new ArrayList<>();
        Point point = this.cellsMap.get(cell);
        
        for(int y = (int) (point.getY() - 1); y <= point.getY() + 1; y++)
            for(int x = (int) (point.getX() - 1); y <= point.getX() + 1; y++)
                if(x >= 0 && y >= 0 && x < this.cols && y < this.rows && x != point.getX() && y != point.getY()) // Vérifier condition x != point.getX() ...
                    neighbours.add(this.cells[x][y]);
        
        return neighbours;
    }
}
