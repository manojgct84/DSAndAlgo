package com.scaler.dc.advance.Searching.assignment;

public class SortedInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 4));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));

        System.out.println(searchInsert(new int[]{1, 4, 5, 9, 10, 15, 20, 21, 22, 31, 38, 40, 41, 44,
                        49, 53, 63, 65, 66, 67, 69, 82, 85, 97, 98, 103, 109, 118, 121, 128, 144, 145, 151,
                        154, 159, 161, 164, 165, 167, 169, 170, 174, 180, 182, 186, 193, 196, 202, 204, 207,
                        213, 214, 219, 221, 228, 231, 232, 235, 240, 246, 249, 250, 252, 254, 260, 264, 266,
                        275, 276, 278, 280, 288, 289, 295, 300, 302, 308, 309, 310, 311, 322, 323, 325, 326,
                        328, 330, 333, 342, 349, 350, 351, 360, 364, 366, 373, 375, 378, 379, 381, 382, 388,
                        390, 393, 394, 396, 398, 405, 410, 415, 428, 430, 431, 434, 436, 458, 463, 467, 470,
                        475, 476, 477, 478, 480, 485, 487, 495, 496, 497, 499, 500, 502, 503, 504, 506, 508,
                        509, 511, 512, 514, 515, 516, 517, 518, 520, 523, 524, 526, 529, 535, 536, 543, 545,
                        547, 550, 551, 552, 553, 554, 560, 564, 573, 577, 580, 582, 585, 589, 591, 593, 594,
                        597, 598, 601, 602, 607, 608, 612, 620, 630, 634, 635, 636, 640, 642, 645, 646, 653,
                        658, 660, 673, 676, 685, 687, 694, 695, 701, 729, 734, 735, 737, 738, 742, 743, 744,
                        749, 750, 751, 758, 764, 766, 770, 774, 775, 778, 781, 782, 784, 790, 792, 793, 794,
                        797, 798, 801, 822, 824, 826, 829, 832, 833, 835, 838, 842, 845, 846, 847, 849, 856,
                        858, 859, 860, 861, 868, 875, 876, 877, 880, 882, 888, 889, 891, 896, 909, 910, 911,
                        912, 917, 922, 925, 926, 929, 930, 933, 942, 943, 945, 946, 953, 956, 959, 966, 968,
                        969, 978, 985, 990, 991, 994, 1000},
                876));


    }

    public static int searchInsert(int[] A, int B) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = (high + low) >> 1;
            if (A[mid] == B || (mid == 0 && B < A[mid]) || (mid > 0 && B < A[mid] && B > A[mid - 1])) {
                return mid;
            } else if (A[mid] < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return A.length;
    }
}
