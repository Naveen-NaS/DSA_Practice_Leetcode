import java.util.Arrays;
import java.util.Comparator;

public class Problem_2931_Jan30 {

    public static long maxSpending(int[][] values) {
        int m = values.length;
        int n = values[0].length;
        int sum = 0;
        int days = 1;

        sort2DArray(values);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int price = values[i][j] * days;
                sum += price;
                days++;
            }
        }

        return sum;
    }

    public static void sort2DArray(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;

        // Flatten the 2D array into a 1D array
        int[] flattenedArray = new int[rows * cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flattenedArray[index++] = array[i][j];
            }
        }

        // Sort the flattened array
        Arrays.sort(flattenedArray);

        // Reconstruct the 2D array with sorted values
        index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = flattenedArray[index++];
            }
        }
    }

    public static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] values = {{999293,998485,992957,992383,989963,986865,986239,984750,983843,983796,983050,979780,979213,978949,978584,976795,973965,973880,972907,966893,966118,964620,961516,961047,959778,958351,952499,951711,948455,948177,947002,945543,944313,939233,937632,934249,933780,932593,931780,931215,927629,927363,922534,922328,921900,919717,915444,914906,913956,912918,911605,911294,910165,909752,909366,908318,904436,902464,902459,898109,893126,889525,886974,885277,884257,883239,882176,881655,877816,876884,876860,871000,870501,870364,869627,868332,867711,867127,864975,864431,863939,862848,861795,861286,861239,861078,860801,860677,860577,860202,856555,854971,854424,853904,853794,853208,851827,851053,850334,848387,848275,846711,845678,845306,844041,840819,840578,837696,837098,834352,832774,828850,824416,824205,821121,820701,820690,820139,819556,818346,815128,811541,811219,804910,804720,803524,803114,796735,796424,790482,789508,786072,785864,785028,784554,784094,780658,780081,778221,776092,774538,774458,773863,773711,770742,769530,760087,759937,759866,758464,758271,757905,757905,757614,756587,752898,752273,749948,747126,746706,745542,744105,743285,742624,742249,741471,741076,740750,740349,736042,734684,734567,734008,730592,728445,724205,723651,721630,720281,713719,713547,713320,713089,712996,710878,709811,707335,702869,702505,702104,699489,696022,695210,691955,690748,688304,681906,681620,681107,680664,679170,675055,674056,671543,670027,669103,665115,664954,661457,660526,659975,659605,658520,658177,656475,655680,654984,648529,648170,646514,640775,640358,640141,635542,635302,628151,627835,627668,625534,624620,621086,618210,618177,616319,616261,615998,615802,615273,611646,610492,608452,607565,607126,607091,606153,604516,602982,602504,602336,601961,600673,599680,599192,598069,597231,596769,593045,587968,587673,587511,579584,579462,578007,578003,577345,576283,575418,575072,574627,573090,570433,570167,570162,569265,567746,567608,563558,563318,563011,560366,560312,560067,558507,557217,556184,554341,553304,553270,550872,550872,550673,549681,546455,545837,545076,544374,541843,541563,540013,539944,538189,537209,536655,535953,535780,535715,533912,532236,530788,530448,530385,527075,526448,525986,524520,524021,523452,520419,519517,518779,518449,515689,514145,514035,511630,508793,505840,505724,504687,504522,503673,501936,501084,498102,497317,496195,495844,495754,494758,494555,489535,489449,487308,487271,486594,485407,481568,480161,478059,472707,469894,468300,468120,465638,464185,463690,457051,455690,455120,453726,453099,452731,452150,448007,447348,445384,445331,444831,444007,443858,442708,441960,440948,436856,436579,436312,434971,434860,433761,433457,430609,430305,429689,426662,424580,420732,418283,418069,410518,408122,403890,403014,402700,402646,402207,398910,398349,395784,395592,395403,394741,394158,393130,392552,392433,389209,383887,381933,381234,380520,379747,379546,376138,372765,372651,372420,368738,366929,364852,364799,358733,358714,352074,351185,347264,346162,342676,338088,332773,331732,331662,327752,327540,327094,326193,324446,320955,318866,318017,314668,314563,314186,312963,311987,310706,308495,308183,307488,307257,306759,306585,304800,303030,302626,301967,301696,300395,299452,298443,297460,295360,293104,292603,291926,291907,290346,281566,279754,275546,272209,272182,271707,270788,267958,266814,266221,265534,264732,263398,261628,260990,260551,260258,257231,257124,254774,253296,251567,248526,248323,247572,247020,243806,242607,242103,240425,239995,239701,239597,235253,233601,232354,232241,231007,230638,229933,227285,225415,222601,222271,220523,219377,219022,216973,216571,216107,215546,215232,215169,213807,213539,213513,210442,209911,209375,207749,205348,200160,198309,196254,194347,191186,189323,189300,187871,185533,182435,180549,178577,176100,174384,173015,170696,166508,166236,163779,163484,160994,159470,159226,154784,152712,152464,151465,150858,150001,148052,147166,145693,145329,144922,143691,143468,143315,142704,140409,137111,135856,135762,133092,131897,131148,126662,126383,125557,125184,122160,121430,121007,119831,117872,112015,111103,110223,109238,108862,107885,107216,107137,101584,98568,97687,97463,96972,95789,95744,91800,90450,89258,87422,85745,85573,84103,83629,83285,81641,80800,80660,79933,79135,79043,78263,77806,76307,76020,75994,74553,73632,71924,67048,66860,66071,65480,63804,62580,62376,62107,60143,59805,58939,58893,57944,55236,54721,54187,54169,50088,49653,48943,47798,46483,45280,41913,40686,39189,29706,28340,26726,26400,23971,23216,22829,22571,21076,18871,18495,15728,15603,14928,14625,10629,9256,8558,7752,7601,4701,1743,802],[998665,998130,997583,996511,995340,994907,985279,982809,982681,982423,981807,980076,972940,972237,971443,970413,968523,963542,963325,961309,958854,958567,955904,954893,954405,954047,952433,947127,943314,941925,941358,940614,940334,938912,938123,937416,935617,934393,933291,933152,933067,932900,932867,931593,926814,926367,924306,923704,923427,922939,922872,922658,920935,920074,918525,917818,917765,916581,916513,914973,911539,910257,904571,899953,899540,898562,898055,897031,895406,892247,891873,891130,891054,888822,888076,884072,882530,879308,878485,876777,875352,875212,874404,873210,870862,870044,869813,868404,868115,865001,864084,860185,859792,857896,857329,857004,855728,853818,851580,851180,848302,847685,847572,847489,846396,845180,843064,842809,842746,841097,836958,836661,836438,829553,829508,827328,825834,824787,822962,821574,820669,820074,819888,819424,816868,816644,816345,815920,808776,806725,805728,804143,804065,800943,793225,787729,786971,786369,785110,781823,781317,778502,778328,778284,777485,775517,773551,773319,772440,771377,770544,765832,765562,763988,763675,763381,762274,759298,756585,755381,753600,750340,749675,748935,747326,746461,745198,744336,741088,740763,740715,740232,739227,738098,735652,733217,731487,731164,725658,722799,720837,718270,717185,716576,716065,714557,714548,714543,714400,712478,709908,708023,706723,705667,704538,702461,701370,701335,701235,697950,695741,691270,690916,690895,690014,685815,682215,679509,679408,678697,676858,675762,673628,672726,670834,668939,667691,663479,661185,660783,660114,659452,657928,657912,656096,654069,653587,650670,649740,647214,646560,646314,646002,643822,642306,640792,640598,639788,636455,635608,634730,628741,628004,627016,625343,622368,621954,621519,621427,615689,611791,610937,608532,606381,606272,604713,602864,602535,601408,599058,596857,596580,594937,594276,593340,592017,588078,587767,586117,585742,584891,584549,583579,583370,581650,581227,576702,574733,574599,573859,573771,570956,568590,568559,566947,566899,566882,564418,564094,561675,561198,559631,558970,555927,555295,553308,550094,548761,548045,547661,547517,546341,544183,542956,542354,542275,541504,540062,539548,538046,536341,533247,532185,528738,528145,527905,526589,524427,523983,523243,521746,521359,518728,516907,516588,515539,515453,513808,512005,507992,505989,504594,504585,504392,503386,502324,501688,500976,499870,498309,493931,493727,491780,489005,488460,488300,488239,486056,486008,484152,482648,481514,479545,477929,477868,477007,475720,473521,471603,466515,461884,460238,459835,458314,458202,457955,457521,455627,455104,455022,454937,453664,451633,450729,448244,447886,447173,447134,444829,443055,442833,441098,440452,440267,439203,438570,436718,435588,435498,433367,425511,424396,419992,413615,412103,410999,410562,408681,403610,403105,402192,402010,401146,399918,398505,397729,397094,395340,393379,392192,392190,391452,391077,390920,388509,381577,380001,379637,378711,378431,378017,377318,376813,375523,374279,373610,370905,370889,370459,369474,366872,361307,360802,360766,356545,355423,355369,353002,350684,349864,349067,348910,347991,347410,342688,340185,339112,338123,334146,330189,329828,328732,325849,325651,319712,319466,318741,314866,313923,313369,311157,310854,310622,309401,307300,305268,304117,303073,302186,300362,299546,298776,297635,297043,296805,296155,295862,295553,292280,291070,288533,287903,287593,286982,286125,284845,281004,279604,279076,277689,277105,277010,275950,275482,272977,272580,271698,269679,267190,264988,263359,262982,261613,260303,258955,253019,251117,250815,250574,246394,245073,245022,244834,242864,241172,240395,239872,239284,237199,235092,234754,221200,219906,219415,219354,217979,214735,212763,210489,209597,209294,208402,205794,202702,200345,198879,193944,192293,192134,190311,188645,188381,188205,187646,187147,187073,186763,181833,179958,179660,179481,178732,176339,175189,174239,173358,171770,170729,169141,168670,166769,165637,165621,164918,164414,163486,161631,159652,154522,151960,146814,146361,144662,142412,141566,138304,137888,135161,132499,131683,131678,131298,130697,129020,126096,125983,123571,119040,118757,115783,115740,111605,110639,110135,110078,105430,105280,105069,103097,101951,101697,101568,97689,94780,94006,93580,92235,90902,89642,89480,88631,83404,82236,80866,78572,78189,74486,73890,73637,70691,69582,67776,60059,59620,59441,57047,56992,56559,55716,53720,52069,49318,49120,48933,48567,47681,46256,45222,44129,43091,40373,40034,36236,34508,33577,32676,32663,32345,22986,17712,17467,16850,16613,16193,15382,13607,11729,11402,10063,9280,9232,7096,6079,5818,3540,3525,2524,1512],[999276,999262,998454,998339,996800,995193,989863,989817,989793,987214,987130,986377,986360,986268,984472,982341,977865,976201,975603,975468,974292,971204,968447,967900,967047,966421,965472,965043,964203,964095,963109,960763,959901,956617,955393,954199,947637,945395,943246,942189,940905,937648,936748,936079,932416,931042,923288,921496,921326,921326,918928,913824,912852,912053,910763,910052,909504,908914,908018,907506,907243,903907,903252,901003,899726,899214,898809,897961,895663,892999,892601,891721,888757,886197,886028,883009,881368,880491,880227,874799,874448,873815,872903,871997,870421,869755,868120,867325,866579,864885,864730,862340,855577,854019,851010,850919,850572,848732,846949,840064,839293,837541,834123,831648,829927,829615,828998,825958,825054,823218,823093,821454,821042,818866,818190,818130,817076,815520,814616,814363,813673,812725,812652,811745,809530,809191,807625,804444,802767,801222,799926,799858,788055,787850,787501,787304,785657,784810,784037,778220,777625,776352,775449,775308,774318,773435,770333,769408,769138,768559,765990,764572,763866,762786,761978,760196,757020,755005,752941,749343,747606,745995,742395,741414,741353,740932,740749,740395,740068,739920,739550,739455,739445,738387,736962,736424,736352,732906,732539,731286,729622,728318,724231,722576,722186,721743,721457,719918,719735,718789,718410,716647,712730,706667,705635,705516,705500,701073,698777,697618,694510,693792,693592,693041,690761,690720,690349,689820,689214,687433,687035,686905,686671,685946,685900,684549,682357,680370,678632,678494,677711,677594,677279,675909,675744,675314,673973,673110,671622,671604,671596,670591,668436,666010,665095,664521,663179,662074,660905,660550,659441,658758,657400,656807,654162,653969,653714,651573,651228,645377,644763,643788,642907,640687,638694,636625,635515,635445,632342,627069,623045,620264,617024,616391,613739,611364,610914,608813,605769,604377,602111,600107,594230,592948,592548,591559,591253,590806,590327,585002,584056,581846,581231,580456,575578,574294,573818,572465,571756,571133,570153,569472,566311,565966,565774,564506,563847,563441,563439,562249,559480,558946,558048,557691,557244,556160,554786,552960,552746,552098,550499,549516,549092,547894,542856,542588,539042,535885,535393,531520,531422,528570,528222,527076,525794,524600,517486,516722,516054,514444,509159,505376,504446,504265,503010,502107,500216,498945,496736,494770,494545,493949,492520,483995,483712,481581,478753,478392,475925,474248,474068,471956,471452,471264,469794,465953,464081,463404,461291,460001,457622,456592,456406,454808,454159,453462,451844,450529,443350,441149,438821,438792,437747,435985,434983,432471,431054,430089,429985,429549,428420,428333,427024,425757,425645,425079,424106,423939,422526,421217,419755,419213,418682,417937,416372,414969,414642,413132,412387,411602,408146,406755,405088,404926,403975,402421,399128,397899,396519,395256,385610,385609,384805,383580,383275,382134,381140,380315,378244,376985,371610,370427,367160,367022,366869,366152,364651,364285,355245,353565,353384,352839,351847,351427,349393,346134,344068,342626,341389,336931,336663,335780,335672,332428,330722,330299,325705,324734,324091,321459,320939,320557,318718,318705,317079,315076,312404,309493,307828,307511,306653,304596,302657,300173,300157,299178,294134,293181,292299,291657,290109,288516,286784,286368,284751,283858,283708,282890,281993,281813,280900,280473,279503,279357,277664,277144,274894,271827,271678,270025,269494,269005,268656,267140,264196,256240,255728,255456,252919,251797,250303,248840,248377,248371,247194,246537,244144,244013,242876,242872,242466,242382,240695,240566,238670,235296,231713,231412,230727,229463,229098,228987,225710,224876,224836,223499,221052,218876,215370,214590,214039,211817,210873,208641,208392,202860,202546,202302,200271,199736,198771,198234,196633,196073,195585,194639,192489,191644,190541,188677,185576,180378,180370,179135,178517,174883,173407,169898,169497,169090,169020,167150,164803,162245,162151,161215,160643,159817,158025,157145,155833,153987,153348,152629,152081,150794,150359,145076,142978,142508,141387,141187,140796,139118,138627,138360,136728,135715,133549,130389,130075,128671,127205,126333,124572,121557,117369,116863,116286,115451,115367,114739,114584,114455,113759,111780,111774,111333,110545,109712,106413,105590,104644,104081,103440,101351,99435,97153,96649,94540,93848,90115,89508,88806,87963,87424,84294,82133,81225,79658,79082,78791,76305,70089,69166,68072,67228,67204,63645,62402,58570,56471,56350,55882,53307,45588,45548,44720,38222,35135,30417,29110,28486,27435,24893,24131,24127,22808,22347,20978,17787,12659,11804,4414,3828,2735,1986,1391],[995675,994605,994502,993663,992562,992324,990578,989080,986210,985975,985774,985117,981837,980264,977627,976160,975860,972303,969873,969731,966611,963734,962522,960964,959620,959209,959003,957944,957757,956438,955964,953813,953360,952081,951627,951594,950426,949371,947069,944653,943777,943123,942949,940298,939565,938366,938232,936062,935577,935070,933461,931732,931080,929171,928668,928415,927654,924662,923991,922353,921379,918388,915771,913802,910996,909623,908921,908272,907078,902943,901938,899560,897135,893851,892321,886429,882428,880545,877725,877017,876948,876799,875474,873392,871688,871529,869397,867971,867402,866027,863574,860186,859979,859734,859313,857984,855950,853350,851565,847328,845410,844239,843549,843031,842391,840665,839261,835690,834907,833101,831979,827919,826854,824766,823746,822989,820850,819816,818997,818896,818362,817639,815360,813298,811810,810555,810314,809622,809535,809215,808515,804834,804177,802759,801155,798749,798278,795220,794188,793911,793605,792179,786821,785364,784948,783395,782529,780443,780275,778618,777967,773557,771680,771296,770474,769312,767773,766876,766587,765477,764952,764213,762940,762085,757701,756635,755932,755827,752089,749993,748240,748141,744724,743977,742816,739167,737981,730404,730118,729561,729195,725024,724868,724668,722534,721003,716559,712102,711221,710273,709956,709381,708607,705593,704815,703718,703263,698277,698260,696821,695945,695782,694256,693827,693528,692580,691692,691250,683375,683337,681268,677661,674343,672782,671127,670863,669503,668902,668553,666721,665952,665012,662325,661175,661103,660864,657907,656699,656069,655669,654258,654215,653693,651754,651233,650952,650583,650405,647730,647475,642345,641099,637394,637236,636954,635284,631521,630443,629786,629656,628343,626912,621677,621279,617599,617427,617053,616638,614226,614224,613585,612138,611844,608105,607573,603121,599969,599657,598980,596676,596169,593662,592902,591246,589098,588769,587502,586348,585956,585330,583112,582220,579662,579568,578535,578385,577580,577064,573425,572618,571480,571082,568228,565666,563180,562437,562373,561918,561671,560227,555830,553504,553046,550389,547467,544928,538939,538216,537778,536801,536524,535561,534674,526438,523085,519775,516019,515375,514941,514719,508971,505225,499259,498622,496492,495666,495138,493577,493076,491502,490792,490504,489734,489376,489288,488270,487612,485257,483344,480806,479285,478614,478591,476488,475535,473781,473308,472352,471309,470066,466999,465805,464968,464907,464476,463709,457084,455413,454149,453684,453520,453517,447274,446483,443816,442942,442541,441931,436094,432837,431245,427317,427196,426584,424438,423594,421548,420815,420283,420006,419343,410443,405482,405476,403544,402986,401440,400725,400189,399837,399153,398927,398771,397404,397154,394400,391707,390652,388201,386345,385696,385691,381384,377132,375726,375562,375414,375347,370291,367911,366998,366567,366046,365133,359234,359224,358318,352122,350044,350007,348072,344951,344015,343829,343458,343178,342058,341126,339088,338638,338378,334410,329579,329567,328343,325276,324703,324594,323496,322185,320532,317827,317659,316390,315830,310717,309756,309330,306481,306480,305796,303600,301309,299214,297246,295955,295472,293673,293123,292650,291490,290472,289287,288988,287004,285134,284672,280981,279873,279592,277236,274939,274718,273783,272425,270134,265229,264987,264355,264066,257693,256805,254546,250823,249722,249641,248411,243885,239009,238633,237249,236975,236211,234853,231397,230457,230000,229548,227458,225996,225347,223780,220641,220031,219974,218518,218418,214116,212459,212048,211107,209647,208063,206926,206638,204927,202871,202084,199257,196458,194948,193093,192331,192099,190909,189233,188756,188720,188657,187324,187093,183713,183448,182787,182431,181980,181482,181396,179793,179703,177369,177309,176706,176167,173752,173352,170579,169800,168665,167087,164713,164558,159307,157916,156582,156358,154806,154177,152690,149728,147941,144977,144138,143626,143620,138543,137749,136896,132610,131424,131096,130137,129782,128410,127201,125432,123985,123231,122491,121194,120900,118918,117363,116023,115903,112285,111682,111211,111201,109880,107607,107469,105911,104267,103371,100874,99903,98956,98759,98661,96592,95913,93421,92234,91647,89913,88927,88700,87276,86170,82467,81228,81164,80738,79367,79143,78895,78375,77599,75757,74477,70327,70326,66707,66270,65040,64467,63510,58083,56507,56079,54735,54632,54562,52512,51803,51581,49985,49434,48862,45831,44484,43705,40571,39422,38597,37816,37256,35032,34931,34042,33118,32986,32486,29098,27992,27423,24620,22365,22190,22066,20253,15374,10711,9684,8458,5743,307],[998767,996119,994939,994504,993739,993410,992851,992560,990021,989795,989456,988495,988302,985443,984355,984068,983781,981311,981290,980378,979555,978979,977808,977095,976348,975792,974558,973479,969982,967830,967819,964586,963788,962891,961567,955220,953710,953090,949108,948608,947930,946045,944344,942111,941779,941470,940633,940250,940193,935351,933196,929433,929299,929063,926244,925756,925405,925129,923207,922554,920738,918981,918925,918386,918363,917854,915079,914189,911204,909247,908921,908162,907538,905916,903187,901388,900698,898618,896172,896157,895986,894133,893869,893447,893308,890519,890231,888419,885991,883750,880591,878225,874916,874738,872024,870776,870567,868377,866493,865613,864312,862978,858155,856635,856481,856158,856078,855890,854857,854847,853851,853472,853038,852197,851192,848079,845352,843741,841752,841635,841068,834296,833695,833031,830095,829195,825506,823237,822079,820948,820275,818979,818520,813867,813392,812722,811753,811433,809438,808362,803444,803311,801403,800962,797296,793862,793248,791564,788509,786230,782596,781511,778468,777415,774525,774353,773864,773120,769407,768242,764385,764011,761833,761169,761054,760777,759704,759498,759271,758478,753633,753321,753106,752666,751774,750676,749519,748844,746591,745071,743898,740246,740124,737320,733531,732389,731580,731017,729563,729015,727276,726912,725248,724467,723120,722813,722360,719235,719117,715791,714068,710134,707587,706061,704388,702540,701945,700502,699188,698465,692376,691971,689997,689444,689231,687735,684813,683122,680714,678867,676469,676095,675075,672817,672720,667077,666803,663257,662907,661645,659747,659741,652734,652544,650256,649510,648845,646865,644717,644507,641714,641661,640962,637250,637186,636505,634952,628672,628178,627980,626814,625073,624167,623885,623768,616950,614202,614172,612575,612548,610704,607701,604397,602904,601661,597751,597307,596707,596525,593049,592114,587486,587094,585644,585220,584432,583820,583601,583216,582873,579291,578940,577293,577257,574725,572982,572841,572351,571276,569955,569784,568824,566932,564741,564406,563223,561356,561159,561137,559439,558915,557109,556873,555053,554131,553584,552078,550922,549276,549229,548800,548441,545705,545580,545195,544990,544878,544486,543828,537660,537363,535358,535309,534553,529428,528221,527604,524499,524068,521687,521265,520271,517048,516797,516673,510565,508584,503767,501841,497365,496660,495320,494980,494816,492939,489798,488112,486281,485138,483067,477332,475850,473678,473350,469808,466680,464149,463224,460260,459013,457058,454291,454100,451213,450822,445429,444510,444464,442365,441760,440868,440821,440199,439991,439808,439763,438636,438041,428635,428116,427325,427221,422487,421732,421038,420970,420694,420412,418632,417747,416411,416077,415219,411221,409543,404490,404355,403442,403286,398384,397569,396872,396627,388672,387718,386820,386456,384593,382422,377846,377810,375869,375860,375764,374564,374169,374057,371319,369648,368593,367835,364410,359468,359355,358396,357291,355056,353729,352081,352061,350380,347754,344659,343422,342000,336957,336916,334223,331253,330962,329132,326700,326195,324800,322383,318631,316403,315529,314212,313865,309744,308721,308318,306056,305488,304675,303866,300705,300519,299404,298489,294012,293271,292878,291986,291717,291473,288870,288284,287655,286455,285259,284726,282675,282436,281612,278973,278430,275638,273837,272963,269232,268447,265952,265027,262690,262667,262514,262447,262184,261557,261545,261459,260420,260038,258213,254250,252855,252761,251344,250333,247419,247130,242079,241709,241388,240924,237153,229791,229631,228978,228786,227727,227250,223714,222908,222318,221088,219225,217260,214265,213703,212491,212002,211480,211444,209979,209580,209303,208725,204801,203159,203079,202641,197905,196606,195686,194743,194154,193399,193315,193040,192896,190925,190146,189725,187323,184496,184062,182061,181227,180546,179171,179163,178735,178719,175757,175469,174918,173677,173422,170952,170277,170123,169601,168394,167143,163150,161440,161436,156695,151959,144173,143339,142999,139747,138585,138536,136694,135261,134322,133732,132291,131500,126829,123517,119961,117415,117245,117166,115776,111819,111069,110916,110022,108665,108200,107140,104152,102406,102351,101701,100843,97405,96994,94005,93236,92221,90336,83254,80360,79461,76330,75770,72949,71692,70286,68945,68237,68064,67439,61665,59905,59199,59089,57840,54715,54547,53366,51122,50355,50180,48888,48135,47863,46566,44314,43241,42332,40459,35866,34482,34053,33259,31866,31233,30098,28680,26126,22513,21460,19799,17073,15030,13198,11592,11549,10310,7166,6504,4782,4737,4412,4393,3145,2311,1734,1499],[999477,999261,998658,997390,997086,995328,993381,993166,992401,992198,991775,991562,991101,990991,990696,989241,986371,985555,983902,983110,982481,980337,980242,978539,974692,968918,967821,967297,967264,966462,966295,965416,964357,961948,961792,961513,961441,961370,961160,960119,957070,956282,956140,949458,948310,945762,945538,942299,937159,936950,936673,935765,932158,928360,927864,924665,924289,923183,922934,920204,918982,918866,917487,916021,915744,915308,914416,914102,913737,913709,912832,911631,909973,909560,907704,905146,904607,902826,902497,901579,898062,894928,891812,891382,890925,889955,889567,887538,887436,885406,884865,884751,882597,879362,877733,876959,876008,873074,873058,871424,869470,867570,866396,864086,862886,859613,855364,853695,852581,850081,847593,847299,845657,842471,841757,839638,839580,838966,838282,835142,835054,829927,829757,828829,827706,824568,819388,817417,814608,812743,812224,805493,804770,804729,802642,799496,797927,796002,793082,792226,787804,787352,787165,786243,784527,782270,781997,781540,781369,780121,777856,774429,767358,767209,765771,765133,764197,764186,762884,762197,761723,761603,761594,761340,759473,758877,758023,755588,755028,754445,752808,752737,752303,751888,750650,750097,748893,748159,747989,747832,745224,744838,742837,742134,741379,741286,737391,737067,737051,736516,735170,733044,730822,730330,730099,729155,727427,725274,723990,722830,716717,716709,716654,715986,715419,715319,713054,712788,710815,708287,707561,705841,703943,700439,697231,696120,691611,690626,690516,683489,681954,681147,680655,676525,673481,672528,672368,671382,670660,669150,669077,668868,668204,666647,664576,662903,662027,660494,657855,655391,653409,650338,649980,648051,646021,641649,641349,639709,637154,634221,633191,632148,632063,631468,631136,629959,629627,627953,626453,626411,622221,622169,618248,617407,617266,616691,615547,612307,612278,611905,610895,608067,606409,606320,601829,601716,598901,597898,597549,597464,596717,596207,595138,595073,591740,589752,587097,585410,584603,584172,583755,580737,580099,579243,579127,578080,577736,576776,576056,569198,568419,565635,565037,563023,562568,559981,553832,553708,552977,551641,551285,550112,549058,548313,547121,545621,543204,542563,539059,537229,535492,534704,532877,531531,529386,526771,526182,522433,519187,516279,515305,514378,513114,508268,507943,505420,504017,502908,501606,501216,500251,500220,499175,498645,497678,496941,496441,494958,483985,482301,480576,477426,474374,470093,469976,469469,469071,468081,467381,467328,466627,466438,464870,463943,462040,461800,461592,461060,461044,459942,459021,458047,456223,454254,451011,450408,447028,446540,445222,444615,444353,441964,440675,437547,436724,434864,432059,431493,431346,429299,428439,423993,420915,420766,418705,414966,414877,412838,412231,408669,408133,408011,407928,407298,407294,406456,405642,400286,396773,395374,391505,391392,391331,388044,384224,383892,383326,382079,381733,379926,378729,378522,375440,371576,371517,370190,368780,366449,363918,359658,357504,356903,354965,347274,346888,345260,342154,339042,338065,331490,331026,329033,325862,324254,320195,319820,318691,316309,311968,309705,305652,303574,300876,299769,298606,297249,297160,296114,293807,292915,292084,291800,290636,290588,289663,288549,286816,282635,279210,274405,273148,272588,268601,265818,261895,261740,257384,256831,256624,255717,255711,254720,254583,254583,253896,252960,252641,251190,248833,248819,248229,247778,245790,243836,240022,239232,239062,235781,235653,232146,231205,231162,229762,229692,229581,229464,229042,228275,227921,227478,226911,224690,224152,222843,222788,219896,217726,217011,216999,214896,207088,206797,206570,199881,198039,197041,193244,191905,188122,187583,186765,186219,184003,183283,182128,181669,177227,176134,175623,175489,175052,175043,174911,174657,171976,171256,168312,168161,166965,166193,162531,161293,160115,159751,158806,154323,153937,153687,150529,149350,148174,146983,145884,144386,143880,141350,140712,140647,138761,138267,136067,134777,133086,132100,129956,129798,126655,125704,121264,119834,118485,118066,117542,117306,116902,116093,115421,112631,108016,106711,106608,106084,106078,105651,104162,103923,101938,101395,100046,98384,97853,97442,95302,95208,94546,92635,92439,92340,90748,88127,87972,87586,85738,84989,83982,83511,82978,82719,82549,80714,79099,78061,73930,70403,69921,67889,66407,63713,60766,59976,59423,58710,57787,56931,56170,56116,50616,49284,48812,47669,45845,41023,39191,38470,37559,37151,36131,34120,32491,28329,28090,27782,26869,26652,15275,14521,14453,14407,13261,12451,9675,8938,8371,5750,5412,5239,4642,107],[995936,993902,993196,992465,990517,988362,987048,985889,985749,984338,978707,978144,975780,973596,973504,972088,969595,968566,964823,959624,958481,957752,956566,954902,953199,949946,948822,947667,944971,944324,944014,942178,939944,939696,938828,934222,933051,931650,931294,928523,928202,924540,923504,922744,915168,912438,912431,912205,911511,910640,910160,903427,902782,901843,900676,898908,898478,895754,894786,894621,894007,889244,885533,883550,883385,882900,882720,882632,881785,881464,877078,872223,867293,866460,866386,863306,859440,858540,858285,857212,853995,853287,852018,851318,849941,848353,848002,846778,846185,845654,843684,842899,842703,838002,836813,834660,832449,832127,828096,827651,827175,826627,825960,824157,823315,822212,821794,820639,820325,819970,819203,818695,816219,815174,812907,811458,811309,810427,810191,806942,804866,803723,803123,800248,796579,794874,787471,781992,781952,780393,779537,777418,777158,776625,774915,774212,773652,773607,773442,773371,772803,771335,762142,761947,758023,757425,756403,755936,754239,752965,746459,743108,741659,741312,738871,738121,736553,731386,730565,729087,728816,728198,728059,727193,726316,724064,723573,722613,721731,720910,719506,718243,717985,717794,717104,716778,716409,716229,715745,714722,713686,712940,712001,709113,708921,707485,706843,705630,704735,700544,698364,697972,697389,695637,695584,695024,694368,693493,692338,688917,687185,685884,685492,684782,684725,684098,683126,682894,681115,680379,679239,677215,676547,676214,676105,675185,673072,671397,670947,668450,666724,664908,664021,660620,655553,655072,650201,650159,647033,646412,644780,644369,642931,638293,636142,636022,631850,630864,629611,629527,629127,627867,624474,624434,624174,624089,620556,617473,617277,616732,615946,615331,613799,610998,608010,606647,605885,605243,603720,602840,601152,597110,595518,592660,591251,588306,587123,587007,586295,584975,582567,581232,577744,576961,575674,575670,575590,574238,573359,572489,572115,571785,569962,568908,567483,567360,566457,565202,563393,561796,561121,561017,560616,557916,553574,552928,549326,549200,548320,545261,543206,541405,539189,539172,538776,538182,536632,534923,531368,528849,527368,526115,526003,524572,521634,520751,520308,517123,516807,516408,515703,513538,510260,509321,508324,506211,506111,503020,499312,498241,496421,495870,494235,494225,493332,493225,490100,489617,488506,486297,485773,482168,480668,476099,475507,472668,472421,472258,471651,471544,471521,470281,468469,464291,463344,462337,461625,460913,460831,460494,460234,460170,457969,456909,455968,454933,454692,452502,451662,450426,448962,448811,447958,447034,445053,443709,443454,443301,442475,442164,436691,434126,433374,432843,429792,429393,428910,427339,425767,425390,424950,424788,421670,419457,418904,418767,418597,414769,414659,414428,414116,413810,412731,407254,406045,405917,401059,400353,399021,398955,398769,398746,396465,390558,389880,389040,387874,387087,386113,384784,380323,377919,376952,376556,375744,375286,374375,374268,373854,373300,372866,371030,370879,370311,367486,365928,365811,363622,363484,361829,361609,360437,356938,356101,355926,355921,355017,350595,349734,349554,348489,347562,346240,345850,344564,341064,338709,336999,336803,334007,332002,331787,330869,330164,330127,324674,322447,321491,319424,317662,314940,314007,310454,310175,308744,302415,299775,293196,289255,287638,286661,285935,283799,282044,282006,277871,277476,276980,275281,275161,273606,272425,270268,268936,267984,264360,258426,256934,252725,251057,249858,249692,249168,248690,247240,246377,246182,244957,236543,233676,231351,231309,230741,229788,227563,223805,221502,216920,212235,209848,209699,209639,209562,208383,208275,208250,208059,207034,205804,204576,203573,201530,200702,200266,197438,197099,193678,191947,190504,187267,186489,184664,183171,179253,177100,173240,172884,169583,168297,168241,167966,165460,160858,158745,157965,157016,156187,153565,150152,150142,147937,147593,147352,146367,145528,144712,142321,141963,139401,139240,138118,136579,135485,134495,134245,133077,131755,131060,125074,123448,122903,121828,121320,119000,118563,116822,116052,115789,111287,108093,105452,104231,102049,100834,100833,99710,95261,91142,90199,89069,88625,83432,83262,82395,81135,80457,80330,79625,77647,76760,75271,73768,73363,73294,73154,72204,71201,70813,70544,70204,70134,68223,67579,67013,65951,65180,60724,60614,59759,57153,55895,53665,53535,51190,51025,45914,45543,44907,44021,43857,43239,42872,41937,40486,37899,37792,34986,34961,33976,32510,31862,31419,30961,30123,29601,27993,27934,27342,27320,24437,22368,20773,18922,18609,10960,7910,4728,2507],[999894,999579,999512,999189,999028,994855,990532,990492,990005,989467,986797,984886,980303,979478,979216,978291,975647,973740,971651,971487,970431,969630,968134,964085,963547,955773,953014,950293,950084,947781,947455,947149,945268,943829,939719,937447,937384,937286,935716,932141,929789,929414,929033,929006,928768,928745,925532,925058,924988,924669,924289,920688,919993,918739,916533,914877,914739,913551,908769,908741,904681,904543,903881,903611,901754,901181,900131,895759,893849,890869,890802,888771,885082,883076,880775,879753,876460,875962,875558,875269,874490,874154,873691,872792,872465,872000,871125,868893,867401,865780,864956,864929,861827,860701,860500,857355,857109,856027,855733,852829,852299,850907,848669,848051,847936,846737,845554,845428,842744,842733,841880,841232,839512,838134,837479,837330,837050,836320,835103,835089,833881,833769,830736,830321,830101,829488,828044,827898,827805,826893,821594,815898,815837,815499,812822,810781,808697,807763,807657,807346,807164,806659,805767,797164,794239,793548,792217,791565,789770,789369,786537,783038,778949,776207,774111,772659,772298,770308,769460,769357,768680,768136,767870,767562,767300,766955,766301,763263,761832,761670,761076,759289,758911,758801,754346,754302,753174,750928,750520,746865,746665,746095,743550,743479,742792,742675,742188,740529,740261,738622,737892,737512,737408,736376,736194,734709,734463,734275,726234,724483,724321,723694,719309,719120,717253,711308,707493,704793,703850,699522,698465,697927,697138,694287,693634,693339,692175,690328,686063,685415,681722,681638,680325,680007,677493,672204,670653,670387,670295,670022,668922,668461,667679,665834,663425,660184,659518,659192,656382,655810,655774,654056,650688,649855,647248,646037,645621,643762,643386,643018,637975,636826,635631,631089,629116,628228,627704,626042,625927,625333,625026,623205,619637,618293,616249,613256,612404,610573,610368,609141,604164,603954,603748,603501,597509,592528,589350,588550,588293,583655,580679,580583,579751,579480,577854,577520,576740,573515,572916,569515,566227,563318,563185,563152,562988,561885,556219,554698,554589,554060,553858,552737,550594,549296,548851,547848,547790,545518,544503,543988,540740,535802,534619,531616,529712,528718,528402,527585,527447,527368,521199,520286,518899,515941,514203,513580,512289,511916,509553,506364,506076,505699,504425,500174,499525,498646,497337,495273,491485,488352,488166,487370,485037,483022,480781,480167,479608,479439,478997,478705,477176,474733,473498,473095,471523,470228,468163,468083,467296,463965,463136,462307,459894,457304,456052,452225,451178,447467,446944,445517,444960,442273,441233,438957,437492,435649,433707,432799,431289,431173,429752,425200,424669,421367,420027,419059,418352,417166,412806,411628,409623,407606,406069,403984,403397,401919,401649,401189,399964,397346,395847,394350,393549,392798,391968,391564,389750,389538,389272,385451,381103,379274,378379,377890,377834,377564,377345,375426,373573,370425,368344,367520,366861,362171,361270,359971,358981,358394,355424,355084,354232,353206,352455,350782,350062,349008,348351,347409,346766,344513,341910,341184,340842,340553,340375,339631,339593,337074,335494,334918,332568,331932,330237,328413,328111,327131,321608,321601,319717,317118,316636,315547,315497,314218,310960,310702,310235,308885,307022,305297,304813,303783,303678,303572,303373,301340,300294,297914,296993,294791,292338,291027,290050,289722,288238,286538,283686,282938,280298,279836,274105,273940,273763,273252,267611,260211,258539,257830,256566,256566,255904,255851,251424,246875,243945,243582,243133,241256,239140,238142,235419,234400,234069,234040,232250,232035,228717,228122,228104,227724,226322,225893,224067,222855,222426,221365,220833,219804,218295,216176,214371,211388,208943,208665,208493,206422,206131,203871,203236,202627,200628,200480,198723,197964,191422,188439,187682,187407,186968,185166,183396,182744,182065,177435,176440,175440,172344,168165,166259,165483,164590,163613,159608,159268,158737,158089,157724,155929,154776,153973,152939,152146,148722,143620,135335,134767,133740,132018,131107,127980,127953,127825,127743,125552,121337,120901,120356,120260,117107,116442,115619,115356,114900,112224,111771,110637,104282,102198,101892,101831,100267,99235,97362,97066,94939,93110,87945,82910,80098,78049,76775,76725,75589,75328,73390,71868,71079,70999,68454,62979,62196,57380,57334,55967,55593,53768,53676,51450,49732,49584,48380,48249,47723,47669,46970,46745,44280,43617,41414,41136,40848,40727,39771,38078,37889,34080,33840,28678,28273,27764,27745,24973,23606,22177,18697,17684,16458,16220,15035,12733,12669,11670,11092,10724,6098,5609,5504,2003}};

        sort2DArray(values);

        printArray(values);

        System.out.println(maxSpending(values));
    }
}
