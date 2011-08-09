//
//  DataController.m
//  Nellodee
//
//  Created by Ada Hopper on 09/08/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "DataController.h"
#import "Category.h"

@implementation DataController

@synthesize categoriesList;

- (id)init {
    if (self = [super init]) {
        [self loadData];
    }
    return self;
}

- (void)loadData {
    
    
    NSMutableArray *categories = [[NSMutableArray alloc] init];
	Category *cat = [[Category alloc]init];
	
	cat.title=@"Medicine and Dentistry";
	cat.subcategories = [[NSMutableArray alloc] 
						 initWithObjects:@"Pre-clinical Medicine",@"Pre-clinical Dentistry",@"Clinical Medicine",
										 @"Clinical Dentistry",@"Others in Medicine and Dentistry",nil];
   	[categories addObject:cat];
	
	cat.title=@"Biological Sciences";
	cat.subcategories = [[NSMutableArray alloc] 
						 initWithObjects:@"Biology",@"Botany",@"Zoology", @"Genetics",@"Microbiology",@"Sports Science"
						 @"Molecular Biology, Biophysics and Biochemistry",@"Psychology",
						 @"Others in Biological Sciences",nil];
   	[categories addObject:cat];

	cat.title=@"Veterinary Sciences and Agriculture";
	cat.subcategories = [[NSMutableArray alloc] 
						 initWithObjects:@"Pre-clinical Veterinary Medicine",@"Clinical Veterinary Medicine and Dentistry",
						 @"Animal Science", @"Agriculture",@"Forestry",@"Food and Beverage studies"
						 @"Agricultural Sciences",@"Others in Veterinary Sciences and Agriculture",nil];
   	[categories addObject:cat];
    
	cat.title=@"Physical Sciences";
	cat.subcategories = [[NSMutableArray alloc] 
						 initWithObjects:@"Chemistry",@"Materials Science",@"Physics", @"Forensic and Archaeological Science",
						 @"Astronomy",@"Geology", @"Ocean Sciences",@"Others in Physical Sciences",nil];
   	[categories addObject:cat];
    
	cat.title=@"Mathematical and Computer Sciences";
	cat.subcategories = [[NSMutableArray alloc] 
						 initWithObjects:@"Mathematics",@"Operational Research",@"Statistics", @"Computer Science",
						 @"Information Systems",@"Software Engineering", @"Artificial Intelligence",
						 @"Others in Mathematical and Computing Sciences",nil];
   	[categories addObject:cat];
	
	// ...
	
	self.categoriesList = categories;
	[cat release];
	[categories release];
}


@end
