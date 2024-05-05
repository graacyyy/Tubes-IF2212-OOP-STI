package game;

public class GameMap {
    private final int width = 11;
    private final int height = 6;
    private final Tile[][] mapGrid;

    public GameMap() {
        this.mapGrid = new Tile[height][width];
        initializeMap();
    }

    private void initializeMap() {
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                mapGrid[x][y] = new Tile('.', false, false, false);

                while (x == 2 && x == 3){
                    while (y >= 1 && y <= 9){
                        mapGrid[x][y].setIsPoolArea(true);;
                    }
                }

                while (y == 0){
                    mapGrid[x][y].setIsRestricted(true);
                }
            }
        }
    }

    public Tile[][] getMapGrid() {
        return mapGrid;
    }

    public void displayMap() {
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                System.out.print(mapGrid[x][y].getType() + "   ");
            }
            System.out.println();
        }
    }
}