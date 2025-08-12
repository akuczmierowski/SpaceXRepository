package pl.andrzejkuczmierowski.internal;

  public enum MissionStatus {
        SCHEDULED("Scheduled"), PENDING("Pending"), IN_PROGRESS("In progress"), ENDED("Ended");
        private String status;
        MissionStatus(String status) {
            this.status = status;
        }
        public String getStatus() {
            return status;
        }
    }