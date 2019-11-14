package innlevering.enteties;

import java.util.List;

public class Gbfs {
    private long last_updated;
    private int ttl;
    private Data data;

    public long getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(long last_updated) {
        this.last_updated = last_updated;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        private Nb nb;

        public Nb getNb() {
            return nb;
        }

        public void setNb(Nb nb) {
            this.nb = nb;
        }

        public static class Nb {
            private List<Feed> feeds;

            public List<Feed> getFeeds() {
                return feeds;
            }

            public void setFeeds(List<Feed> feeds) {
                this.feeds = feeds;
            }

            public static class Feed {
                private String name;
                private String url;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
