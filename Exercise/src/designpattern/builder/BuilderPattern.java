package designpattern.builder;

public class BuilderPattern {
    public static void main(String[] args) {
//	BuilderPattern.Builder builder = new BuilderPattern.Builder(240, 8);
//	builder.calories(100);
//	builder.sodium(35);
//	builder.carbohydrate(27);
//	NutritionFacts cocaCola = builder.build();
//	System.out.println(cocaCola);
	
	// �� �ٸ��� builder�� Ÿ�������� �ʾƵ� �Ǿ� ���ϴ�.
	BuilderPattern cocaCola = new BuilderPattern
	    .Builder(240, 8)
	    .calories(100)
	    .sodium(35)
	    .carbohydrate(27)
	    .build();
	System.out.println(cocaCola);
    }
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // Required parameters(�ʼ� ����)
        private final int servingSize;
        private final int servings;

        // Optional parameters - initialized to default values(������ ���ڴ� �⺻������ �ʱ�ȭ)
        private int calories      = 0;
        private int fat           = 0;
        private int carbohydrate  = 0;
        private int sodium        = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings    = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;    // �̷��� �ϸ� . ���� ü���� �̾ �� �ִ�.
        }
        public Builder fat(int val) {
            fat = val;
            return this;
        }
        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }
        public Builder sodium(int val) {
            sodium = val;
            return this;
        }
        public BuilderPattern build() {
            return new BuilderPattern(this);
        }
    }

    private BuilderPattern(Builder builder) {
        servingSize  = builder.servingSize;
        servings     = builder.servings;
        calories     = builder.calories;
        fat          = builder.fat;
        sodium       = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}
