class TimeMap {
  HashMap<String, TreeMap<Integer, String>> table;
  
  public TimeMap() {
    table = new HashMap<>();      
  }
    
  public void set(String key, String value, int timestamp) {
    TreeMap<Integer, String> current = table.get(key);
    if(current == null) current = new TreeMap<>();
    
    current.put(timestamp, value);
    table.put(key, current);
  }
    
  public String get(String key, int timestamp) {
    TreeMap<Integer, String> current = table.get(key);
     if(current == null) return "";
    
    Map.Entry<Integer, String> it = current.floorEntry(timestamp);
    return it == null ? "" : it.getValue();
  }
}